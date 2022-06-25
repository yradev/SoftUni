package com.example.spotifyplaylistapp.service;

import com.example.spotifyplaylistapp.model.dto.SongAddDTO;
import com.example.spotifyplaylistapp.model.entity.Song;

import java.util.List;

public interface SongService {
    boolean add(SongAddDTO songAddDTO);

    Song findSong(String performer);
}
