package products_shop.Controllers;

import products_shop.Services.ProductService;
import products_shop.Services.SeedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import products_shop.Services.UserService;

import java.util.Scanner;

@Component
public class Controller implements CommandLineRunner {
    private SeedService seedService;
    private ProductService productService;
    private UserService userService;
    private ExerciseController exerciseController;
    private Scanner scanner;

    @Autowired
    public Controller(SeedService seedService, ExerciseController exerciseController) {
        this.seedService = seedService;
        this.exerciseController = exerciseController;
        scanner = new Scanner(System.in);
    }

    @Override
    public void run(String... args) throws Exception {
        seedService.seedAllData();

        while (true) {
            try {
                exerciseController.getInputRules();
                String input = scanner.nextLine();
                if (input.equalsIgnoreCase("stop")) {
                    break;
                }

                exerciseController.getExercise(Integer.parseInt(input));

            } catch (Exception e) {
                System.out.println("ERROR: " + e.getMessage());
            }
        }
    }
}
//        System.out.println("");
//        System.out.printf(IMPORT_SEPARATOR,"Products in Range");
//        productService.findProductsInRange(1,1000);
//
//        System.out.printf(IMPORT_SEPARATOR,"Successfully Sold Products");
//        userService.getUserBySoldProjects();
//
//        System.out.println("");
//        System.out.printf(IMPORT_SEPARATOR,"Categories by Products Count");
//        productService.getCategorisFromProductsCount();
//        System.out.println("");
//
//        System.out.printf(IMPORT_SEPARATOR,"Users and Products");
//        userService.getUsersByCountSoldProjects();
//        System.out.println("");
//
//        System.out.println(END_SEPARATOR);
//    }
//}
