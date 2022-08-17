package com.likebookapp.controller;

import com.likebookapp.service.PostService;
import com.likebookapp.service.UserService;
import com.likebookapp.session.CurrentSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {
    private final CurrentSession currentSession;
    private final PostService postService;
    public HomeController(CurrentSession currentSession, PostService postService) {
        this.currentSession = currentSession;
        this.postService = postService;
    }

    @GetMapping
    public ModelAndView getIndex(ModelAndView modelAndView){
        if(!currentSession.isLogged()){
            modelAndView.setViewName("index");
            return modelAndView; // •	Guest (not logged in) users can access the Index page.
        }

        // •	Users (logged in) can access the Home page.
        modelAndView.setViewName("home");
        modelAndView.addObject("currentUserPost",postService.getPostsCurrentUser(currentSession.getUsername()));
        modelAndView.addObject("otherUsersPosts",postService.getOtherUsersPosts());

        return modelAndView;
    }
}
