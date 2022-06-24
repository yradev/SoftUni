package source.controller;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import source.model.dto.AddOrderDTO;
import source.model.entity.Order;
import source.service.OrderService;
import source.session.CurrentSession;

import javax.validation.Valid;

@Controller
@RequestMapping("/order")
public class OrderController {
    private final CurrentSession currentSession;
    private final OrderService orderService;
    private final ModelMapper modelMapper;

    public OrderController(CurrentSession currentSession, OrderService orderService, ModelMapper modelMapper) {
        this.currentSession = currentSession;
        this.orderService = orderService;
        this.modelMapper = modelMapper;
    }


    @GetMapping("/add")
    public String getAdd(){
        if(!currentSession.isLogged()){
            return "redirect:/";
        }

        return "order-add";
    }

    @ModelAttribute("addOrderDTO")
    public AddOrderDTO initAddOrderDTO(){
        return new AddOrderDTO();
    }

    @PostMapping("/add")
    public String postAdd(@Valid AddOrderDTO addOrderDTO, BindingResult bindingResult, RedirectAttributes redirectAttributes){

            if (bindingResult.hasErrors()) {
                redirectAttributes.addFlashAttribute("addOrderDTO", addOrderDTO);
                redirectAttributes.addFlashAttribute(
                        "org.springframework.validation.BindingResult.addOrderDTO", bindingResult);
                return "redirect:/order/add";
            }

        orderService.add(addOrderDTO);
            return "redirect:/";
    }

    @GetMapping("/ready")
    public String deleteOrder(@RequestParam long id){
        orderService.delete(id);
        return "redirect:/";
    }
}
