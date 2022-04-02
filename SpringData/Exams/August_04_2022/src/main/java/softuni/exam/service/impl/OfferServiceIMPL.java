package softuni.exam.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import softuni.exam.models.dto.offer.exportDTO.OfferBestDTO;
import softuni.exam.models.dto.offer.importDTO.CollectionOfOfferImportsDTO;
import softuni.exam.models.dto.offer.importDTO.OfferImportDTO;
import softuni.exam.models.entity.Agent;
import softuni.exam.models.entity.Apartment;
import softuni.exam.models.entity.ApartmentTypes;
import softuni.exam.models.entity.Offer;
import softuni.exam.repository.AgentRepository;
import softuni.exam.repository.ApartmentRepository;
import softuni.exam.repository.OfferRepository;
import softuni.exam.service.OfferService;
import softuni.exam.util.DtoValidator;
import softuni.exam.util.XmlParser;

import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static softuni.exam.util.Paths.OFFERS_DATA;

@Service
public class OfferServiceIMPL implements OfferService {
    private final OfferRepository offerRepository;
    private final AgentRepository agentRepository;
    private final ApartmentRepository apartmentRepository;

    private final ModelMapper modelMapper;

    @Autowired
    public OfferServiceIMPL(OfferRepository offerRepository, AgentRepository agentRepository, ApartmentRepository apartmentRepository, ModelMapper modelMapper) {
        this.offerRepository = offerRepository;
        this.agentRepository = agentRepository;
        this.apartmentRepository = apartmentRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public boolean areImported() {
        return offerRepository.count()>0;
    }

    @Override
    public String readOffersFileContent() throws IOException {
        return Files.readString(OFFERS_DATA);
    }

    @Override
    public String importOffers() throws IOException, JAXBException {
        return XmlParser.fromXml(CollectionOfOfferImportsDTO.class,OFFERS_DATA.toFile()).getOffers().stream()
                .map(this::importValidRecordToDB)
                .collect(Collectors.joining(System.lineSeparator()));
    }

    @Override
    public String exportOffers() {
        return offerRepository.BestOffers().stream()
                .map(a->modelMapper.map(a,OfferBestDTO.class))
                .map(OfferBestDTO::toString)
                .collect(Collectors.joining());

    }

    private String importValidRecordToDB(OfferImportDTO offerImportDTO){
        if(!DtoValidator.validate(offerImportDTO)){
            return "Invalid offer";
        }

        Agent agent = agentRepository.findAgentByFirstName(offerImportDTO.getAgent().getName());

        if(agent==null){
            return "Invalid offer";
        }

        Apartment apartment = apartmentRepository.findById(offerImportDTO.getApartment().getId()).get();

        Offer offer =  modelMapper.map(offerImportDTO,Offer.class);
        offer.setApartment(apartment);
        offer.setAgent(agent);

        offerRepository.save(offer);
        return String.format("Successfully imported offer %.2f",offerImportDTO.getPrice());
    }
}
