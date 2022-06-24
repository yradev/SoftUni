package source.controller;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import source.model.dto.ShipAddDTO;
import source.model.dto.ShipViewDTO;
import source.model.entity.Ship;
import source.service.ShipService;
import source.session.CurrentSession;

import javax.validation.Valid;

@Controller
@RequestMapping("/ship")
public class ShipController {
    private final CurrentSession currentSession;
    private final ShipService shipService;

    public ShipController(CurrentSession currentSession, ShipService shipService) {
        this.currentSession = currentSession;
        this.shipService = shipService;
    }

    @GetMapping("/add")
    public String getAdd(){
        if(!currentSession.isLogged()){
            return "redirect:/";
        }
        //Users (logged in) can access Add Ship page.
        return "ship-add";
    }

    @ModelAttribute("shipAddDTO")
    public ShipAddDTO initShipAddDTO(){
        return new ShipAddDTO();
    }

    @PostMapping("/add")
    public String postAdd(@Valid ShipAddDTO shipAddDTO, BindingResult bindingResult, RedirectAttributes redirectAttributes){
        if(bindingResult.hasErrors() || !shipService.add(shipAddDTO)){
            redirectAttributes.addFlashAttribute("shipAddDTO", shipAddDTO);
            redirectAttributes.addFlashAttribute(
                    "org.springframework.validation.BindingResult.shipAddDTO", bindingResult);
            return "redirect:/ship/add";
        }
        return "redirect:/home";
    }

    @PostMapping("/attack")
    public String postFire(@RequestParam String attackerName, @RequestParam String defenderName){
        shipService.fight(attackerName,defenderName);
        return "redirect:/home";
    }
}
