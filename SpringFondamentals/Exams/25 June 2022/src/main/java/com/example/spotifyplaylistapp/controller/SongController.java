package com.example.spotifyplaylistapp.controller;

import com.example.spotifyplaylistapp.model.dto.SongAddDTO;
import com.example.spotifyplaylistapp.model.entity.Song;
import com.example.spotifyplaylistapp.model.entity.User;
import com.example.spotifyplaylistapp.repository.SongRepository;
import com.example.spotifyplaylistapp.service.SongService;
import com.example.spotifyplaylistapp.service.UserService;
import com.example.spotifyplaylistapp.session.CurrentSession;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
@RequestMapping("/song")
public class SongController {
    private final CurrentSession currentSession;
    private final SongService songService;
    private final UserService userService;


    public SongController(CurrentSession currentSession, SongService songService, UserService userService) {
        this.currentSession = currentSession;
        this.songService = songService;
        this.userService = userService;
    }

    @GetMapping("/add")
    public String getAdd(){
        if(!currentSession.isLogged()){
            return "redirect:/";
        }
        return "song-add";
    }

    @ModelAttribute("songAddDTO")
    public SongAddDTO initSongAddDTO(){
        return new SongAddDTO();
    }

    @PostMapping("/add")
    public String postAdd(@Valid SongAddDTO songAddDTO, BindingResult bindingResult, RedirectAttributes redirectAttributes) {
            if (bindingResult.hasErrors() || !songService.add(songAddDTO)) {
                redirectAttributes.addFlashAttribute("songAddDTO", songAddDTO);
                redirectAttributes.addFlashAttribute(
                        "org.springframework.validation.BindingResult.songAddDTO", bindingResult);
                return "redirect:/song/add";
            }
        return "redirect:/";
    }
}
