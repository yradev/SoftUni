package source.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import source.service.OrderService;
import source.service.UserService;
import source.session.CurrentSession;

@Controller
@RequestMapping("/")
public class HomeController {
    private final CurrentSession currentSession;
    private final OrderService orderService;
    private final UserService userService;

    public HomeController(CurrentSession currentSession, OrderService orderService, UserService userService) {
        this.currentSession = currentSession;
        this.orderService = orderService;
        this.userService = userService;
    }

    @GetMapping()
    public ModelAndView gotHomePage(ModelAndView modelAndView){
        if(!currentSession.isLogged()){
            modelAndView.setViewName("index");
            //Guest (not logged in) users can access Index page.
            return modelAndView;
        }
        //Users (logged in) can access Home page.


        modelAndView.setViewName("home");
        modelAndView.addObject("orderViewDTO",orderService.getOrders());
        modelAndView.addObject("totalOrderTime",orderService.totalTimeToPrepare());
        modelAndView.addObject("employeeViewDTO",userService.getEmployeeOrders());
        return modelAndView;
    }
}
