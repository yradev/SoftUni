package com.example.spotifyplaylistapp.service;

import com.example.spotifyplaylistapp.model.dto.UserLoginDTO;
import com.example.spotifyplaylistapp.model.dto.UserRegisterDTO;
import com.example.spotifyplaylistapp.model.dto.UserViewDTO;
import com.example.spotifyplaylistapp.model.entity.Song;
import com.example.spotifyplaylistapp.model.entity.User;

public interface UserService {
    boolean register(UserRegisterDTO userRegisterDTO);
    boolean login(UserLoginDTO userLoginDTO);
    void logout();

    UserViewDTO getCurrentUser();

    void addSong(long songID);

    void clear();
}
