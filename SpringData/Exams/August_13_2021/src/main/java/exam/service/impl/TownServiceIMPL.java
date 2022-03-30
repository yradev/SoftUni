package exam.service.impl;

import exam.model.town.ImportDTO.CollectionOfTownImportsDTO;
import exam.model.town.ImportDTO.TownImportDTO;
import exam.model.town.Town;
import exam.repository.TownRepository;
import exam.service.TownService;
import exam.service.ValidatingService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.util.stream.Collectors;

import static exam.util.Paths.XML_TOWNS_DATA;

@Service
public class TownServiceIMPL implements TownService {
    private final ValidatingService validatingService;
    private final TownRepository townRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public TownServiceIMPL(ValidatingService validatingService, TownRepository townRepository, ModelMapper modelMapper) {
        this.validatingService = validatingService;
        this.townRepository = townRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public boolean areImported() {
        return townRepository.count()>0;
    }

    @Override
    public String readTownsFileContent() throws IOException {
        return Files.readString(XML_TOWNS_DATA);
    }

    @Override
    public String importTowns() throws JAXBException, FileNotFoundException {
        Unmarshaller unmarshaller = JAXBContext.newInstance(CollectionOfTownImportsDTO.class).createUnmarshaller();
        CollectionOfTownImportsDTO collectionOfTownImportsDTO = (CollectionOfTownImportsDTO) unmarshaller.unmarshal(XML_TOWNS_DATA.toFile());

        return collectionOfTownImportsDTO.getTown().stream()
                .map(this::importValidDataToDataBase)
                .collect(Collectors.joining(System.lineSeparator()));
    }

    private String importValidDataToDataBase(TownImportDTO townImportDTO) {
        if(!validatingService.ValidateTown(townImportDTO)) {
            return "Invalid Town";
        }

        townRepository.save(modelMapper.map(townImportDTO, Town.class));
        return String.format("Successfully imported Town %s",townImportDTO.getName());
    }
}
