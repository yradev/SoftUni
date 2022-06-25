package com.example.spotifyplaylistapp.service;

import com.example.spotifyplaylistapp.model.dto.StyleViewDTO;
import com.example.spotifyplaylistapp.model.entity.Style;
import com.example.spotifyplaylistapp.model.entity.Styles;

import java.util.List;

public interface StyleService {
    void seedStyles();
    Style getStyle(Styles style);

    List<StyleViewDTO> getAllStyles();
}
