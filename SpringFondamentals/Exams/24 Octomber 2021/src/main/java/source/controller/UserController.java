package source.controller;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import source.model.dto.UserLoginDTO;
import source.model.dto.UserRegisterDTO;
import source.service.UserService;
import source.session.CurrentSession;

import javax.validation.Valid;

@Controller
@RequestMapping("/user")
public class UserController {

    private final CurrentSession currentSession;
    private final UserService userService;

    public UserController(CurrentSession currentSession, UserService userService) {
        this.currentSession = currentSession;
        this.userService = userService;
    }

    @GetMapping("login")
    public String getLogin(){
        if(currentSession.isLogged()){
            return "redirect:/home";
        }

        //Guest (not logged in) users can access Login page.
        return "login";
    }

    @GetMapping("register")
    public String getRegister(){
        if(currentSession.isLogged()){
            return "redirect:/home";
        }

        //Guest (not logged in) users can access Register page.
        return "register";
    }

    @ModelAttribute("userRegisterDTO")
    public UserRegisterDTO initUserRegisterDTO(){
        return new UserRegisterDTO();
    }

    @PostMapping("/register")
    public String postRegister(@Valid UserRegisterDTO userRegisterDTO, BindingResult bindingResult, RedirectAttributes redirectAttributes){
        if(bindingResult.hasErrors() || !userService.register(userRegisterDTO)){
            redirectAttributes.addFlashAttribute("userRegisterDTO", userRegisterDTO);
            redirectAttributes.addFlashAttribute(
                    "org.springframework.validation.BindingResult.userRegisterDTO", bindingResult);
            return "redirect:/user/register";
        }

        return "redirect:/";
    }

    @ModelAttribute("userLoginDTO")
    public UserLoginDTO initUserLoginDTO(){
        return new UserLoginDTO();
    }

    @PostMapping("/login")
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

        return "redirect:/home";
    }

    @GetMapping("/logout")
    public String logout(){
        if(!currentSession.isLogged()){
            return "redirect:/";
        }
        userService.logout();
        //Users (logged in) can access Logout functionality.
        return "redirect:/";
    }
}
