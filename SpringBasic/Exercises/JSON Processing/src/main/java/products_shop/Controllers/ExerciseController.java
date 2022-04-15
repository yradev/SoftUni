package products_shop.Controllers;

import products_shop.Services.ProductService;
import products_shop.Services.SeedService;
import products_shop.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;

import static car_dealer.messages.core.*;

@Component
@Transactional
public class ExerciseController {

    private SeedService seedService;
    private ProductService productService;
    private UserService userService;

    @Autowired
    public ExerciseController(SeedService seedService, ProductService productService, UserService userService) {
        this.seedService = seedService;
        this.productService = productService;
        this.userService = userService;
    }

    public void getInputRules() {
        System.out.println(INPUT_START);
        printExercise(
                "Products in Range",
                "Successfully Sold Products",
                "Categories by Products Count",
                "Users and Products"
                );
        System.out.println();
        System.out.println(ENTER_STOP);

    }

    public void getExercise(int number) {
        switch (number){
            case 1 -> System.out.println(productService.findProductsInRange(1,1000));
            case 2 -> System.out.println(userService.getUserBySoldProjects());
            case 3 -> System.out.println(productService.getCategorisFromProductsCount());
            case 4 -> System.out.println(userService.getUsersByCountSoldProjects());
            default -> System.out.println(INVALID_INPUT);
        }
        System.out.println("");
        System.out.println("---------------------------------------------------------");
        System.out.println("");
    }

    private void printExercise(String ... values){
        int count = 1;
        for (String value : values) {
            System.out.printf(EXERCISES_VALUES,count,value);
            count++;
        }

    }
}
