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
    private final SeedService seedService;
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