package com.example.football.models.dto.player;

import com.example.football.models.entity.Positions;

import static com.example.football.util.Messages.BEST_PLAYER_OUTPUT;

public class BestPlayerDTO {
    private String firstName;
    private String lastName;
    private Positions position;
    private String teamName;
    private String teamStadiumName;

    public BestPlayerDTO(){}

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public String getTeamStadiumName() {
        return teamStadiumName;
    }

    public void setTeamStadiumName(String teamStadiumName) {
        this.teamStadiumName = teamStadiumName;
    }

    public Positions getPosition() {
        return position;
    }

    public void setPosition(Positions position) {
        this.position = position;
    }

    @Override
    public String toString() {
        return String.format(BEST_PLAYER_OUTPUT,firstName,lastName,position,teamName,teamStadiumName);
    }
}
