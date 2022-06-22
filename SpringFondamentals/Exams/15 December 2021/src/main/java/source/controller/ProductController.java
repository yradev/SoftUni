package source.controller;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import source.model.dto.AddProductDTO;
import source.service.ProductService;
import source.session.CurrentSession;

import javax.validation.Valid;

@Controller
@RequestMapping("/product")
public class ProductController {
    private CurrentSession currentSession;
    private ProductService productService;

    public ProductController(CurrentSession currentSession, ProductService productService) {
        this.currentSession = currentSession;
        this.productService = productService;
    }

    @GetMapping("/add")
    public String addProductGet(){
        if(!currentSession.isLogged()){
            return "redirect:/";
        }
        //Users (logged in) can access Add Product page.
        return "product-add.html";
    }

    @ModelAttribute("addProductDTO")
    public AddProductDTO initRegistrationDTO() {
        return new AddProductDTO();
    }

    @PostMapping("/add")
    public String addProductPost(@Valid AddProductDTO addProductDTO, BindingResult bindingResult, RedirectAttributes redirectAttributes){

        if(bindingResult.hasErrors()){
            redirectAttributes.addFlashAttribute("addProductDTO", addProductDTO);
            redirectAttributes.addFlashAttribute(
                    "org.springframework.validation.BindingResult.addProductDTO", bindingResult);

            return "redirect:/product/add";
        }

        productService.addProduct(addProductDTO);
        return "redirect:/";
    }

    @GetMapping("/buy")
    public String deleteProduct(@RequestParam long id){
        if(!currentSession.isLogged()){
            return "redirect:/";
        }
        productService.deleteProduct(id);
        return "redirect:/home";
    }

    @GetMapping("buyAll")
        public String deleteAllProducts(){
        if(!currentSession.isLogged()){
            return "redirect:/";
        }
        productService.deleteAllProducts();
        return "redirect:/home";
    }
}
