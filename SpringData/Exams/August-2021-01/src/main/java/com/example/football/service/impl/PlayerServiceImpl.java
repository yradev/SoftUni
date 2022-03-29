package com.example.football.service.impl;

import com.example.football.models.dto.player.BestPlayerDTO;
import com.example.football.models.dto.player.importDTO.CollectionOfPlayerImportsDTO;
import com.example.football.models.dto.player.importDTO.PlayerImportDTO;
import com.example.football.models.entity.Player;
import com.example.football.models.entity.Stat;
import com.example.football.models.entity.Team;
import com.example.football.models.entity.Town;
import com.example.football.repository.PlayerRepository;
import com.example.football.repository.StatRepository;
import com.example.football.repository.TeamRepository;
import com.example.football.repository.TownRepository;
import com.example.football.service.PlayerService;
import com.example.football.service.ValidatingService;
import org.modelmapper.MappingException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.IOException;
import java.nio.file.Files;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.List;
import java.util.stream.Collectors;

import static com.example.football.util.Messages.DATA_IMPORTED_SUCCESSFULLY;
import static com.example.football.util.Messages.DATA_IMPORTING_FAILED;
import static com.example.football.util.Paths.XML_PLAYERS;

//ToDo - Implement all methods
@Service
public class PlayerServiceImpl implements PlayerService {

    private final PlayerRepository playerRepository;
    private final ValidatingService validatingService;
    private final StatRepository statRepository;
    private final TeamRepository teamRepository;
    private final TownRepository townRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public PlayerServiceImpl(PlayerRepository playerRepository, ValidatingService validatingService, StatRepository statRepository, TeamRepository teamRepository, TownRepository townRepository, ModelMapper modelMapper) {
        this.playerRepository = playerRepository;
        this.validatingService = validatingService;
        this.statRepository = statRepository;
        this.teamRepository = teamRepository;
        this.townRepository = townRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public boolean areImported() {
        return playerRepository.count()>0;
    }

    @Override
    public String readPlayersFileContent() throws IOException {
        return Files.readString(XML_PLAYERS);
    }

    @Override
    public String importPlayers() throws JAXBException {

        Unmarshaller unmarshaller = JAXBContext.newInstance(CollectionOfPlayerImportsDTO.class).createUnmarshaller();

        CollectionOfPlayerImportsDTO collectionOfPlayerImportsDTO = (CollectionOfPlayerImportsDTO) unmarshaller.unmarshal(XML_PLAYERS.toFile());

       return collectionOfPlayerImportsDTO.getPlayers().stream()
                .map(this::importValidDataToMySQL)
                .map(this::getResult)
                .collect(Collectors.joining(System.lineSeparator()));
    }

    private String  getResult(PlayerImportDTO playerImportDTO) {
        if(playerImportDTO==null){
            return String.format(DATA_IMPORTING_FAILED,"Player");
        }else{
            return String.format(DATA_IMPORTED_SUCCESSFULLY + " %s", "Player",playerImportDTO.getFirstName(),playerImportDTO.getLastName(),playerImportDTO.getPosition());
        }
    }

    private PlayerImportDTO importValidDataToMySQL(PlayerImportDTO playerImportDTO) {

        if(validatingService.ValidatePlayer(playerImportDTO)){
            if(playerRepository.findPlayerByEmail(playerImportDTO.getEmail())!=null){
                return null;
            }
                Player player = modelMapper.map(playerImportDTO,Player.class);

                Town town = townRepository.findTownByName(player.getTown().getName());
                Team team = teamRepository.findTeamByName(player.getTeam().getName());
                Stat stat = statRepository.findById(player.getStat().getId());

                player.setTown(town);
                player.setTeam(team);
                player.setStat(stat);

                playerRepository.save(player);

            return playerImportDTO;


        }else{
            return null;
        }
    }

    @Override
    public String exportBestPlayers() {
        LocalDate startDate = LocalDate.of(1995,01,01);
        LocalDate endDate = LocalDate.of(2003,01,01);

        return playerRepository.findBestPlayers(startDate,endDate).stream()
                .map(a->modelMapper.map(a,BestPlayerDTO.class))
                .map(BestPlayerDTO::toString)
                .collect(Collectors.joining(System.lineSeparator()));
    }
}
