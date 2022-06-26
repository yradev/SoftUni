package com.example.spotifyplaylistapp.model.dto;

import java.util.Set;

public class UserViewDTO {
    private int totalMinutes;
    private Set<SongViewDTO> songs;

    public UserViewDTO(){}

    public int getTotalMinutes() {
        return totalMinutes;
    }

    public void setTotalMinutes(int totalMinutes) {
        this.totalMinutes = totalMinutes;
    }

    public Set<SongViewDTO> getSongs() {
        return songs;
    }

    public void setSongs(Set<SongViewDTO> songs) {
        this.songs = songs;
    }
}
