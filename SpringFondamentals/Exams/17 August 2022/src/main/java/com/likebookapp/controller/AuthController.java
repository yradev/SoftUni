package com.likebookapp.controller;

import com.likebookapp.model.dto.UserLoginDTO;
import com.likebookapp.model.dto.UserRegisterDTO;
import com.likebookapp.service.UserService;
import com.likebookapp.session.CurrentSession;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

@Controller
@RequestMapping("auth")
public class AuthController {
    private final UserService userService;
    private final CurrentSession currentSession;

    public AuthController(UserService userService, CurrentSession currentSession) {
        this.userService = userService;
        this.currentSession = currentSession;
    }

    @ModelAttribute("userRegisterDTO")
    public UserRegisterDTO userRegisterDTO(){
        return new UserRegisterDTO();
    }

    @GetMapping("register")
    public String registerUser(){
        if(!currentSession.isLogged()) { //	Guest (not logged in) users can access Register page.
            return "register";
        }
        return "redirect:/";
    }

    @PostMapping("register/processing")
    public String registerProcessing(@Valid UserRegisterDTO userRegisterDTO, BindingResult bindingResult, RedirectAttributes redirectAttributes){

        if(!userRegisterDTO.getPassword().equals(userRegisterDTO.getConfirmPassword())){
            bindingResult.addError(new FieldError("passwordsNotEqual","confirmPassword","Confirm password is not equal to password!"));
        }

        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("userRegisterDTO", userRegisterDTO);
            redirectAttributes.addFlashAttribute(
                    "org.springframework.validation.BindingResult.userRegisterDTO", bindingResult);
            return "redirect:/auth/register";
        }

        userService.registerUser(userRegisterDTO);
        return "redirect:/auth/login";
    }

    @ModelAttribute("userLoginDTO")
    private UserLoginDTO userLoginDTO(){
        return new UserLoginDTO();
    }

    @GetMapping("login")
    public String login(){
        if(!currentSession.isLogged()) { // Guest (not logged in) users can access Login page.
            return "login";
        }

        return "redirect:/";
    }

    @PostMapping("login/processing")
    public String loginProcesing(@Valid UserLoginDTO userLoginDTO, BindingResult bindingResult, RedirectAttributes redirectAttributes, HttpServletRequest request){
        userService.validateLogin(userLoginDTO,bindingResult);

        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("userLoginDTO", userLoginDTO);
            redirectAttributes.addFlashAttribute(
                    "org.springframework.validation.BindingResult.userLoginDTO", bindingResult);
            return "redirect:/auth/login";
        }

        userService.login(userLoginDTO);
        return "redirect:/";
    }

    @GetMapping("logout")
    public String logout(){
        if(currentSession.isLogged()) { // •	Users (logged in) can access the Logout functionality.
            userService.logout();
            return "redirect:/auth/login";
        }
        return "redirect:/";
    }
}
