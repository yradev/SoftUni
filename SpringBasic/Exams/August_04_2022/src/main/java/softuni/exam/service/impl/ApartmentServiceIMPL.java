package softuni.exam.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import softuni.exam.models.dto.apartment.ApartmentImportDTO;
import softuni.exam.models.dto.apartment.CollectionOfApartmentImportsDTO;
import softuni.exam.models.entity.Apartment;
import softuni.exam.models.entity.Town;
import softuni.exam.repository.ApartmentRepository;
import softuni.exam.repository.TownRepository;
import softuni.exam.service.ApartmentService;
import softuni.exam.util.DtoValidator;
import softuni.exam.util.XmlParser;

import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.nio.file.Files;
import java.util.stream.Collectors;

import static softuni.exam.util.Paths.APARTMENTS_DATA;

@Service
public class ApartmentServiceIMPL implements ApartmentService {
    private final ApartmentRepository apartmentRepository;
    private final TownRepository townRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public ApartmentServiceIMPL(ApartmentRepository apartmentRepository, TownRepository townRepository, ModelMapper modelMapper) {
        this.apartmentRepository = apartmentRepository;
        this.townRepository = townRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public boolean areImported() {
        return apartmentRepository.count()>0;
    }

    @Override
    public String readApartmentsFromFile() throws IOException {
        return Files.readString(APARTMENTS_DATA);
    }

    @Override
    public String importApartments() throws IOException, JAXBException {
        return XmlParser.fromXml(CollectionOfApartmentImportsDTO.class,APARTMENTS_DATA.toFile()).getApartments().stream()
                .map(this::importValidRecordToDB)
                .collect(Collectors.joining(System.lineSeparator()));
    }

    private String importValidRecordToDB(ApartmentImportDTO apartmentImportDTO){
        if(!DtoValidator.validate(apartmentImportDTO)){
            return "Invalid apartment";
        }


        Town town = townRepository.findTownByTownName(apartmentImportDTO.getTownTownName());

        if(apartmentRepository.findApartmentByTownAndArea(apartmentImportDTO.getTownTownName(),apartmentImportDTO.getArea()) != null){
            return "Invalid apartment";
        }


        Apartment apartment = modelMapper.map(apartmentImportDTO,Apartment.class);

        apartment.setTown(town);

        apartmentRepository.save(apartment);

        return String.format("Successfully imported apartment %s - %s",apartmentImportDTO.getApartmentType(),apartmentImportDTO.getArea());
    }
}
