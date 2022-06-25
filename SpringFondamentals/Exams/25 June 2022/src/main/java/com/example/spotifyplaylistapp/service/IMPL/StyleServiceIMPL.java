package com.example.spotifyplaylistapp.service.IMPL;

import com.example.spotifyplaylistapp.model.dto.StyleViewDTO;
import com.example.spotifyplaylistapp.model.entity.Style;
import com.example.spotifyplaylistapp.model.entity.Styles;
import com.example.spotifyplaylistapp.repository.StyleRepository;
import com.example.spotifyplaylistapp.service.StyleService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

@Service
public class StyleServiceIMPL implements StyleService {
    private final StyleRepository styleRepository;
    private final ModelMapper modelMapper;

    public StyleServiceIMPL(StyleRepository styleRepository, ModelMapper modelMapper) {
        this.styleRepository = styleRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public void seedStyles() {
        if (styleRepository.count() == 0) {
            Arrays.stream(Styles.values()).map(style -> {
                Style tempStyle = new Style();

                tempStyle.setName(style);
                return tempStyle;
            }).forEach(styleRepository::save);
        }
    }

    @Override
    public Style getStyle(Styles style) {
        return styleRepository.findStyleByName(style);
    }

    @Override
    public List<StyleViewDTO> getAllStyles() {
        List<StyleViewDTO> styleViewDTO = styleRepository.findAll().stream()
                .map(style->modelMapper.map(style,StyleViewDTO.class))
                .peek(style -> style.setUrl(String.format("/img/%s.png",style.getName().name().toLowerCase())))
                .collect(Collectors.toList());
        return styleViewDTO;
    }
}
