package com.example.spotifyplaylistapp.model.dto;

import com.example.spotifyplaylistapp.model.entity.Song;
import com.example.spotifyplaylistapp.model.entity.Styles;

import java.util.Set;

public class StyleViewDTO {
    private long id;
    private Styles name;
    private Set<SongViewDTO>songs;
    private String url;

    public StyleViewDTO(){};

    public Styles getName() {
        return name;
    }

    public void setName(Styles name) {
        this.name = name;
    }

    public Set<SongViewDTO> getSongs() {
        return songs;
    }

    public void setSongs(Set<SongViewDTO> songs) {
        this.songs = songs;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
