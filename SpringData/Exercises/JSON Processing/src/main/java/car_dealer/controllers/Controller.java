package car_dealer.controllers;

import car_dealer.services.SeedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.util.Scanner;

@Component
public class Controller implements CommandLineRunner {
    private final SeedService seedService;
    private final ExerciseController exerciseController;
    private final Scanner scanner;

    @Autowired
    public Controller(SeedService seedService, ExerciseController exerciseController) {
        this.seedService = seedService;
        this.exerciseController = exerciseController;
        scanner = new Scanner(System.in);
    }

    @Override
    public void run(String... args) throws Exception {
        seedService.seedData();

        while(true) {
            try {
                exerciseController.getInputRules();
                String input = scanner.nextLine();
                if(input.equalsIgnoreCase("stop")){
                    break;
                }

                exerciseController.getExercise(Integer.parseInt(input));

            } catch (Exception e) {
                System.out.println("ERROR: " + e.getMessage());
            }
        }
    }
}
