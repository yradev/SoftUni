package com.example.spotifyplaylistapp.controller;

import com.example.spotifyplaylistapp.model.entity.Song;
import com.example.spotifyplaylistapp.service.StyleService;
import com.example.spotifyplaylistapp.service.UserService;
import com.example.spotifyplaylistapp.session.CurrentSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/")
public class HomeController {
     private final CurrentSession currentSession;
     private final StyleService styleService;
     private final UserService userService;

        public HomeController(CurrentSession currentSession, StyleService styleService, UserService userService) {
            this.currentSession = currentSession;
            this.styleService = styleService;
            this.userService = userService;
        }

        @GetMapping()
        public ModelAndView gotHomePage(ModelAndView modelAndView){
            if(!currentSession.isLogged()){
                modelAndView.setViewName("index");
                //Guest (not logged in) users can access the Index page.
                return modelAndView;
            }
            //Users (logged in) can access the Home page.

            modelAndView.setViewName("home");
            modelAndView.addObject("findAll",styleService.getAllStyles());
            modelAndView.addObject("currentLogedUsser",userService.getCurrentUser());
            return modelAndView;
    }
}
