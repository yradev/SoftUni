package com.example.spotifyplaylistapp.controller;

import com.example.spotifyplaylistapp.model.dto.UserLoginDTO;
import com.example.spotifyplaylistapp.model.dto.UserRegisterDTO;
import com.example.spotifyplaylistapp.service.UserService;
import com.example.spotifyplaylistapp.session.CurrentSession;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
@RequestMapping("/user")
public class UserController{
    private final CurrentSession currentSession;
    private final UserService userService;

    public UserController(CurrentSession currentSession, UserService userService) {
        this.currentSession = currentSession;
        this.userService = userService;
    }

    @GetMapping("/register")
    public String getRegister(){
        if(currentSession.isLogged()){
            return "redirect:/";
        } //Guest (not logged in) users can access the Register page.
        return "register";
    }

    @ModelAttribute("userRegisterDTO")
    public UserRegisterDTO initUserRegisterDTO(){
        return new UserRegisterDTO();
    }

    @PostMapping("/register")
    public String postRegister(@Valid UserRegisterDTO userRegisterDTO, BindingResult bindingResult, RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors() || !userService.register(userRegisterDTO)) {
            redirectAttributes.addFlashAttribute("userRegisterDTO", userRegisterDTO);
            redirectAttributes.addFlashAttribute(
                    "org.springframework.validation.BindingResult.userRegisterDTO", bindingResult);
            return "redirect:/user/register";
        }

        return "redirect:/";
    }

    @GetMapping("/login")
    public String getLogin(){
        if(currentSession.isLogged()){
            return "redirect:/";
        }//Guest (not logged in) users can access the Login page.

        return "login";
    }

    @ModelAttribute("userLoginDTO")
    public UserLoginDTO userLoginDTO(){
        return new UserLoginDTO();
    }

    @PostMapping("login")
    public String postLogin(@Valid UserLoginDTO userLoginDTO, BindingResult bindingResult, RedirectAttributes redirectAttributes){

        if(bindingResult.hasErrors() ){
            redirectAttributes.addFlashAttribute("userLoginDTO", userLoginDTO);
            redirectAttributes.addFlashAttribute(
                    "org.springframework.validation.BindingResult.userLoginDTO", bindingResult);
            return "redirect:/user/login";
        }

        if(!userService.login(userLoginDTO)){
            redirectAttributes.addFlashAttribute("loginDTO",userLoginDTO);
            redirectAttributes.addFlashAttribute("badLoginData", true);
            return "redirect:/user/login";
        }

        return "redirect:/";
    }

    @GetMapping("/logout")
    public String logout(){
        if(!currentSession.isLogged()){
            return "redirect:/";
        } // Users (logged in) can access Logout functionality.
        userService.logout();
        return "redirect:/";
    }

    @GetMapping("/addSong")
    public String getAddSong(@RequestParam long id){
        userService.addSong(id);
        return "redirect:/";
    }

    @GetMapping("/clean")
    public String clean(){
        userService.clear();
        return "redirect:/";
    }
}
