package com.example.football.service.impl;

import com.example.football.models.dto.stat.importDTO.CollectionOfStatImportsDTO;
import com.example.football.models.dto.stat.importDTO.StatImportDTO;
import com.example.football.models.entity.Stat;
import com.example.football.repository.StatRepository;
import com.example.football.service.StatService;
import com.example.football.service.ValidatingService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.IOException;
import java.nio.file.Files;
import java.util.stream.Collectors;

import static com.example.football.util.Messages.DATA_IMPORTED_SUCCESSFULLY;
import static com.example.football.util.Messages.DATA_IMPORTING_FAILED;
import static com.example.football.util.Paths.XML_STATS;

//ToDo - Implement all methods
@Service
public class StatServiceImpl implements StatService {
    private final StatRepository statRepository;
    private final ValidatingService validatingService;
    private final ModelMapper modelMapper;

    @Autowired
    public StatServiceImpl(StatRepository statRepository, ValidatingService validatingService, ModelMapper modelMapper) {
        this.statRepository = statRepository;
        this.validatingService = validatingService;
        this.modelMapper = modelMapper;
    }

    @Override
    public boolean areImported() {
        return statRepository.count()>0;
    }

    @Override
    public String readStatsFileContent() throws IOException {
        return Files.readString(XML_STATS);
    }

    @Override
    public String importStats() throws JAXBException {
        Unmarshaller unmarshaller = JAXBContext.newInstance(CollectionOfStatImportsDTO.class).createUnmarshaller();

        CollectionOfStatImportsDTO collectionOfStatImportsDTO =(CollectionOfStatImportsDTO)unmarshaller.unmarshal(XML_STATS.toFile());

       return collectionOfStatImportsDTO.getStats().stream()
                .map(this::saveValidDataToMysql)
                .map(this::getResult)
                .collect(Collectors.joining(System.lineSeparator()));
    }

    private StatImportDTO saveValidDataToMysql(StatImportDTO statImportDTO) {

        if(validatingService.ValidateStat(statImportDTO)){
            if(statRepository.findStatByPassingAndEnduranceAndShooting(statImportDTO.getPassing(),statImportDTO.getEndurance(),statImportDTO.getShooting())!=null){
                return null;
            }

            statRepository.save(modelMapper.map(statImportDTO, Stat.class));
            return statImportDTO;

        }else{
            return null;
        }
    }

    private String getResult(StatImportDTO statImportDTO) {
        if(statImportDTO==null){
            return String.format(DATA_IMPORTING_FAILED,"Stat");
        }else{
            return String.format(DATA_IMPORTED_SUCCESSFULLY + " %s", "Stat",statImportDTO.getPassing(),statImportDTO.getShooting(),statImportDTO.getEndurance());
        }
    }
}
