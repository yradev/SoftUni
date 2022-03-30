package com.example.football.service;

import com.example.football.models.dto.player.importDTO.PlayerImportDTO;
import com.example.football.models.dto.stat.importDTO.StatImportDTO;
import com.example.football.models.dto.team.TeamImportDTO;
import com.example.football.models.dto.town.TownImportDTO;

public interface ValidatingService {
    boolean ValidateTown(TownImportDTO townImportDTO);
    boolean ValidateTeam(TeamImportDTO teamImportDTO);
    boolean ValidateStat(StatImportDTO statImportDTO);
    boolean ValidatePlayer(PlayerImportDTO playerImportDTO);
}
