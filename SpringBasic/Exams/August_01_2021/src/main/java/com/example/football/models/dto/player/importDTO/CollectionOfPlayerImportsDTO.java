package com.example.football.models.dto.player.importDTO;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "players")
@XmlAccessorType(XmlAccessType.FIELD)
public class CollectionOfPlayerImportsDTO {
    @XmlElement(name = "player")
    private List<PlayerImportDTO> players;

    public CollectionOfPlayerImportsDTO(){}

    public CollectionOfPlayerImportsDTO(List<PlayerImportDTO> players){

        this.players = players;
    }

    public List<PlayerImportDTO> getPlayers() {
        return players;
    }

    public void setPlayers(List<PlayerImportDTO> players) {
        this.players = players;
    }
}