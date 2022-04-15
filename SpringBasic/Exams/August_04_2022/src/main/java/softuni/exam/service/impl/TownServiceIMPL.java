package softuni.exam.service.impl;

import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import softuni.exam.models.dto.town.TownImportDTO;
import softuni.exam.models.entity.Town;
import softuni.exam.repository.TownRepository;
import softuni.exam.service.TownService;
import softuni.exam.util.DtoValidator;

import java.io.IOException;
import java.nio.file.Files;
import java.util.Arrays;
import java.util.stream.Collectors;

import static softuni.exam.util.Paths.*;

@Service
public class TownServiceIMPL implements TownService {
    private final TownRepository townRepository;
    private final Gson gson;
    private final ModelMapper modelMapper;

    @Autowired
    public TownServiceIMPL(TownRepository townRepository, Gson gson, ModelMapper modelMapper) {
        this.townRepository = townRepository;
        this.gson = gson;
        this.modelMapper = modelMapper;
    }

    @Override
    public boolean areImported() {
        return townRepository.count()>0;
    }

    @Override
    public String readTownsFileContent() throws IOException {
        return Files.readString(TOWNS_DATA);
    }

    @Override
    public String importTowns() throws IOException {

        return Arrays.stream(gson.fromJson(Files.readString(TOWNS_DATA),TownImportDTO[].class))
                .map(this::importValidRecordToDB)
                .collect(Collectors.joining(System.lineSeparator()));
    }

    private String importValidRecordToDB(TownImportDTO townImportDTO){
        if(!DtoValidator.validate(townImportDTO)){
            return "Invalid town";
        }

        if(townRepository.findTownByTownName(townImportDTO.getTownName())!=null){
            return "Invalid town";
        }

        townRepository.save(modelMapper.map(townImportDTO, Town.class));
        return String.format("Successfully imported town %s - %s",townImportDTO.getTownName(),townImportDTO.getPopulation());
    }
}
