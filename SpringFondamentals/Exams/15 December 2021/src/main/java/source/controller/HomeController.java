package source.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import source.model.dto.ProductViewDTO;
import source.service.ProductService;
import source.session.CurrentSession;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/")
public class HomeController {

    private final CurrentSession currentSession;
    private final ProductService productService;

    @Autowired
    public HomeController(CurrentSession currentSession, ProductService productService) {
        this.currentSession = currentSession;
        this.productService = productService;
    }

    @GetMapping
    public String notLogged(){
        if(currentSession.isLogged()){
         return "redirect:/home"; //
        }
        // Guest (not logged in) users can access Index page.
        return "index"; //
    }

    @GetMapping("/home")
    public ModelAndView logged(ModelAndView modelAndView){
        if(!currentSession.isLogged()){
            modelAndView.setViewName("redirect:/");
        }
        // Users (logged in) can access Home page.

        List<ProductViewDTO> productViewDTOList = productService.getAllProducts();
        double sumPrices = productViewDTOList.stream()
                .map(ProductViewDTO::getPrice)
                .mapToDouble(price -> Double.parseDouble(price.toString()))
                .sum();

        modelAndView.addObject("productView",productViewDTOList);
        modelAndView.addObject("sumPrices",sumPrices);
        return modelAndView;
    }


}