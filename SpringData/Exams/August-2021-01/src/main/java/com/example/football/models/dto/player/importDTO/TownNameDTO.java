package com.example.football.models.dto.player.importDTO;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

@XmlAccessorType(XmlAccessType.FIELD)
public class TownNameDTO {
    @XmlElement
    private String name;

    public TownNameDTO(){}


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
