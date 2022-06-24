package source.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import source.service.ShipService;
import source.session.CurrentSession;

@Controller
public class HomeController {
    private CurrentSession currentSession;
    private ShipService shipService;

    public HomeController(CurrentSession currentSession, ShipService shipService) {
        this.currentSession = currentSession;
        this.shipService = shipService;
    }

    @GetMapping("/")
    public String notLoggedUser(){
        if(currentSession.isLogged()){
            return "redirect:/home";
        }
        // Guest (not logged in) users can access Index page.
        return "index";
    }

    @GetMapping("/home")
    public ModelAndView getHome(ModelAndView modelAndView){
        if(!currentSession.isLogged()){
            return new ModelAndView("redirect:/");
        }
        //Users (logged in) can access Home page.
        modelAndView.setViewName("home");


        modelAndView.addObject("ownedShips",shipService.getShips(true));
        modelAndView.addObject("notOwnedShips",shipService.getShips(false));
        return modelAndView;
    }



}
