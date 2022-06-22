package source.controller;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import source.model.dto.LoginDTO;
import source.model.dto.RegistrationDTO;
import source.service.UserService;
import source.session.CurrentSession;

import javax.validation.Valid;

@Controller
@RequestMapping("user")
public class UserController {
    private final CurrentSession currentSession;
    private final UserService userService;

    public UserController(CurrentSession currentSession, UserService userService) {
        this.currentSession = currentSession;
        this.userService = userService;
    }

    @ModelAttribute("registrationDTO")
    public RegistrationDTO initRegistrationDTO() {
        return new RegistrationDTO();
    }

    @ModelAttribute("loginDTO")
    public LoginDTO initLoginDTO(){
        return new LoginDTO();
    }

    @GetMapping("/register")
    public String getRegister(){
        if(currentSession.isLogged()) {
            return "redirect:/home";
        }
        // Guest (not logged in) users can access Register page.
        return "register";
    }

    @PostMapping("/register")
    public String postRegister(@Valid RegistrationDTO registrationDTO, BindingResult bindingResult, RedirectAttributes redirectAttributes){

        if(bindingResult.hasErrors() || !userService.register(registrationDTO)){
            redirectAttributes.addFlashAttribute("registrationDTO", registrationDTO);
            redirectAttributes.addFlashAttribute(
                    "org.springframework.validation.BindingResult.registrationDTO", bindingResult);
            return "redirect:/user/register";
        }
        return "redirect:/home";
    }

    @GetMapping("/login")
    public String getLogin(){
        if(currentSession.isLogged()) {
            return "redirect:/home";
        } // Guest (not logged in) users can access Login page.
        return "login";
    }

    @PostMapping("/login")
    public String postLogin(@Valid LoginDTO loginDTO, BindingResult bindingResult, RedirectAttributes redirectAttributes){

        if(bindingResult.hasErrors() ){
            redirectAttributes.addFlashAttribute("loginDTO", loginDTO);
            redirectAttributes.addFlashAttribute(
                    "org.springframework.validation.BindingResult.loginDTO", bindingResult);
            return "redirect:/user/login";
        }

        if(!userService.login(loginDTO)){
            redirectAttributes.addFlashAttribute("loginDTO",loginDTO);
            redirectAttributes.addFlashAttribute("badLoginData", true);
            return "redirect:/user/login";
        }

        return "redirect:/home";
    }

    @GetMapping("/logout")
    public String logout(){
        if(!currentSession.isLogged()){
            return "redirect:/";
        }

        //Users (logged in) can access Logout functionality.
        currentSession.logout();
        return "redirect:/";
    }
}
