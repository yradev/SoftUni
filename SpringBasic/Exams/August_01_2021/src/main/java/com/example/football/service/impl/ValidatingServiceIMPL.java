package com.example.football.service.impl;

import com.example.football.models.dto.player.importDTO.PlayerImportDTO;
import com.example.football.models.dto.stat.importDTO.StatImportDTO;
import com.example.football.models.dto.team.TeamImportDTO;
import com.example.football.models.dto.town.TownImportDTO;
import com.example.football.service.ValidatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import java.util.Set;

@Service
public class ValidatingServiceIMPL implements ValidatingService {
    private final Validator validator;

    @Autowired
    public ValidatingServiceIMPL(Validator validator) {
        this.validator = validator;
    }

    @Override
    public boolean ValidateTown(TownImportDTO townImportDTO){
        Set<ConstraintViolation<TownImportDTO>> validate = validator.validate(townImportDTO);
        return validate.isEmpty();

    }

    @Override
    public boolean ValidateTeam(TeamImportDTO teamImportDTO) {
        Set<ConstraintViolation<TeamImportDTO>> validate = validator.validate(teamImportDTO);
        return validate.isEmpty();
    }

    @Override
    public boolean ValidateStat(StatImportDTO statImportDTO) {
        Set<ConstraintViolation<StatImportDTO>> validate = validator.validate(statImportDTO);
        return validate.isEmpty();
    }

    @Override
    public boolean ValidatePlayer(PlayerImportDTO playerImportDTO) {
        Set<ConstraintViolation<PlayerImportDTO>> validate = validator.validate(playerImportDTO);
        return validate.isEmpty();
    }
}
