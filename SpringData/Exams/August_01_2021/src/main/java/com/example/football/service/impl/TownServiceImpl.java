package com.example.football.service.impl;

import com.example.football.models.dto.town.TownImportDTO;
import com.example.football.models.entity.Town;
import com.example.football.repository.TownRepository;
import com.example.football.service.TownService;
import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.util.Arrays;
import java.util.stream.Collectors;


import static com.example.football.util.Messages.*;
import static com.example.football.util.Paths.*;


//ToDo - Implement all methods
@Service
public class TownServiceImpl implements TownService {

    private final TownRepository townRepository;
    private final ValidatingServiceIMPL validatingService;
    private final ModelMapper modelMapper;
    private final Gson gson;

    @Autowired
    public TownServiceImpl(TownRepository townRepository, ValidatingServiceIMPL validatingService, ModelMapper modelMapper, Gson gson) {
        this.townRepository = townRepository;
        this.validatingService = validatingService;
        this.modelMapper = modelMapper;
        this.gson = gson;
    }

    @Override
    public boolean areImported() {
        return townRepository.count() > 0;
    }

    @Override
    public String readTownsFileContent() throws IOException {
        return Files.readString(JSON_TOWNS);
    }

    @Override
    public String importTowns() throws IOException {

        return Arrays.stream(gson.fromJson(Files.readString(JSON_TOWNS), TownImportDTO[].class))
               .map(this::importValidDateToMysql)
               .map(this::getResult)
                .collect(Collectors.joining(System.lineSeparator()));
    }

    private TownImportDTO importValidDateToMysql(TownImportDTO townImportDTO) {
        if(!validatingService.ValidateTown(townImportDTO)){
            return null;
        }else{
            Town town = modelMapper.map(townImportDTO,Town.class);
            townRepository.save(town);
            return townImportDTO;
        }
    }

    private String getResult(TownImportDTO townImportDTO) {
        if (townImportDTO == null) {
           return String.format(DATA_IMPORTING_FAILED, "Town");
        } else {
            return String.format(DATA_IMPORTED_SUCCESSFULLY, "Town", townImportDTO.getName(), townImportDTO.getPopulation());
        }
    }
}