package com.example.football.service.impl;

import com.example.football.models.dto.team.TeamImportDTO;
import com.example.football.models.entity.Team;
import com.example.football.models.entity.Town;
import com.example.football.repository.TeamRepository;
import com.example.football.repository.TownRepository;
import com.example.football.service.TeamService;
import com.example.football.service.ValidatingService;
import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.*;
import java.util.Arrays;
import java.util.stream.Collectors;

import static com.example.football.util.Messages.DATA_IMPORTED_SUCCESSFULLY;
import static com.example.football.util.Messages.DATA_IMPORTING_FAILED;
import static com.example.football.util.Paths.JSON_TEAMS;

//ToDo - Implement all methods
@Service
public class TeamServiceImpl implements TeamService {
    private final TeamRepository teamRepository;
    private final Gson gson;
    private final ValidatingService validatingService;
    private final TownRepository townRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public TeamServiceImpl(TeamRepository teamRepository, Gson gson, ValidatingService validatingService, TownRepository townRepository, ModelMapper modelMapper) {
        this.teamRepository = teamRepository;
        this.gson = gson;
        this.validatingService = validatingService;
        this.townRepository = townRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public boolean areImported() {
        return teamRepository.count()>0;
    }

    @Override
    public String readTeamsFileContent() throws IOException {
        return Files.readString(JSON_TEAMS);
    }

    @Override
    public String importTeams() throws IOException {
        return Arrays.stream(gson.fromJson(Files.readString(JSON_TEAMS),TeamImportDTO[].class))
                .map(this::importValidDateToMysql)
                .map(this::getResult)
                .collect(Collectors.joining(System.lineSeparator()));
    }

    private TeamImportDTO importValidDateToMysql(TeamImportDTO teamImportDTO) {
        if(!validatingService.ValidateTeam(teamImportDTO)) {
            return null;
        }

        else{
            if(teamRepository.findTeamByName(teamImportDTO.getName())!=null){
                return null;
            }

            Team team = modelMapper.map(teamImportDTO,Team.class);
            Town town = townRepository.findTownByName(teamImportDTO.getTownName());

            team.setTown(town);
            teamRepository.save(team);
            return teamImportDTO;
        }
    }

    private String getResult(TeamImportDTO teamImportDTO) {
        if(teamImportDTO==null){
            return String.format(DATA_IMPORTING_FAILED, "Team");
        }else{
            return String.format(DATA_IMPORTED_SUCCESSFULLY, "Team", teamImportDTO.getName(), teamImportDTO.getFanBase());
        }
    }
}
