package com.example.spotifyplaylistapp.service.IMPL;

import com.example.spotifyplaylistapp.model.dto.SongViewDTO;
import com.example.spotifyplaylistapp.model.dto.UserLoginDTO;
import com.example.spotifyplaylistapp.model.dto.UserRegisterDTO;
import com.example.spotifyplaylistapp.model.dto.UserViewDTO;
import com.example.spotifyplaylistapp.model.entity.Song;
import com.example.spotifyplaylistapp.model.entity.User;
import com.example.spotifyplaylistapp.repository.SongRepository;
import com.example.spotifyplaylistapp.repository.UserRepository;
import com.example.spotifyplaylistapp.service.UserService;
import com.example.spotifyplaylistapp.session.CurrentSession;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class UserServiceIMPL implements UserService {
    private final UserRepository userRepository;
    private final ModelMapper modelMapper;
    private final CurrentSession currentSession;
    private final SongRepository songRepository;

    public UserServiceIMPL(UserRepository userRepository, ModelMapper modelMapper, CurrentSession currentSession, SongRepository songRepository) {
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
        this.currentSession = currentSession;
        this.songRepository = songRepository;
    }


    @Override
    public boolean register(UserRegisterDTO userRegisterDTO) {
        if(userRepository.findUserByEmail(userRegisterDTO.getEmail()) != null ||
                userRepository.findUserByUsername(userRegisterDTO.getUsername())!=null ||
                !userRegisterDTO.getPassword().equals(userRegisterDTO.getConfirmPassword())){

            return false;
        }

        User user = modelMapper.map(userRegisterDTO, User.class);
        Set<Song> songs = new LinkedHashSet<>();
        user.setSongs(songs);
        userRepository.save(modelMapper.map(userRegisterDTO, User.class));
        return true;
    }

    @Override
    public boolean login(UserLoginDTO userLoginDTO) {
        if(userRepository.findUserByUsernameAndPassword(userLoginDTO.getUsername(),userLoginDTO.getPassword()) == null){
            return false;
        }
        currentSession.login(modelMapper.map(userLoginDTO,User.class));
        return true;
    }

    @Override
    public void logout() {
        currentSession.logout();
    }

    @Override
    public UserViewDTO getCurrentUser() {
        UserViewDTO user = modelMapper.map(userRepository.findUserByUsername(currentSession.getUsername()),UserViewDTO.class);
        Set<SongViewDTO> mySongs = user.getSongs().stream()
                .peek(song -> {
                    int seconds = song.getDuration();
                    int secondsToMinutes = seconds/60;

                    song.setHours(secondsToMinutes/60);
                    song.setMinutes(secondsToMinutes%60);

                }).collect(Collectors.toSet());

        int totalMinutes = user.getSongs().stream().mapToInt(SongViewDTO::getMinutes).sum();
        user.setTotalMinutes(totalMinutes);
        user.setSongs(mySongs);

        return user;
    }

    @Override
    public void addSong(long songId) {
        User user = userRepository.findUserByUsername(currentSession.getUsername());
        Song song = songRepository.getById(songId);
        user.getSongs().add(song);
        userRepository.save(user);
    }

    @Override
    public void clear() {
        User user = userRepository.findUserByUsername(currentSession.getUsername());
        user.getSongs().clear();

        userRepository.save(user);
    }
}
