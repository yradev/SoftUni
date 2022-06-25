package com.example.spotifyplaylistapp.model.entity;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "styles")
public class Style extends BaseEntity{
    private long id;
    @Enumerated(EnumType.STRING)
    private Styles name;
    @Column(columnDefinition = "text")
    private String description;

    public Style(){}

    @OneToMany(mappedBy = "style",targetEntity = Song.class,fetch = FetchType.EAGER)
    private Set<Song>songs;

    public Styles getName() {
        return name;
    }

    public void setName(Styles name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Set<Song> getSongs() {
        return songs;
    }

    public void setSongs(Set<Song> songs) {
        this.songs = songs;
    }

    @Override
    public long getId() {
        return id;
    }

    @Override
    public void setId(long id) {
        this.id = id;
    }
}
