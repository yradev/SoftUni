package com.example.spotifyplaylistapp.service.IMPL;

import com.example.spotifyplaylistapp.model.dto.SongAddDTO;
import com.example.spotifyplaylistapp.model.entity.Song;
import com.example.spotifyplaylistapp.model.entity.User;
import com.example.spotifyplaylistapp.repository.SongRepository;
import com.example.spotifyplaylistapp.repository.UserRepository;
import com.example.spotifyplaylistapp.service.SongService;
import com.example.spotifyplaylistapp.service.StyleService;
import com.example.spotifyplaylistapp.service.UserService;
import com.example.spotifyplaylistapp.session.CurrentSession;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

@Service
public class SongServiceIMPL implements SongService {
    private final SongRepository songRepository;
    private final StyleService styleService;
    private final ModelMapper modelMapper;
    private final UserService userService;
    private final UserRepository userRepository;
    private final CurrentSession currentSession;

    public SongServiceIMPL(SongRepository songRepository, StyleService styleService, ModelMapper modelMapper, UserService userService, UserRepository userRepository, CurrentSession currentSession) {
        this.songRepository = songRepository;
        this.styleService = styleService;
        this.modelMapper = modelMapper;
        this.userService = userService;
        this.userRepository = userRepository;
        this.currentSession = currentSession;
    }

    @Override
    public boolean add(SongAddDTO songAddDTO) {
        if(songRepository.findByPerformer(songAddDTO.getPerformer())!=null){
            return false;
        }
        songAddDTO.setStyle(styleService.getStyle(songAddDTO.getStyleName()));
        songRepository.save(modelMapper.map(songAddDTO,Song.class));
        return true;
    }

    @Override
    public Song findSong(String performer) {
        return songRepository.findByPerformer(performer);
    }

}
