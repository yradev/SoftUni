package Controllers;

import Connector.DBConnector;
import Include.ExerciseController;

import java.util.Scanner;

import static Messages.CoreMessages.*;


public class Controller {
    public static void run() {
        Scanner scanner = new Scanner(System.in);

        while (true){
            try{
                DBConnector.connect();
            }catch (IllegalStateException e){
                break;
            }
        }

       String input;
        while (true) {
            ExerciseController homeworks = new HomeworksController(DBConnector.getConnection());
            homeworks.infoText();
            input = scanner.nextLine();
            if(input.equalsIgnoreCase("Stop")){
                break;
            }
            
            try {
                ExerciseController exercises = homeworks.getHomework(Integer.parseInt(input));
                if(exercises == null){
                    throw new IllegalArgumentException(INVALID_INPUT);
                }
                getExercises(exercises, scanner);
            }catch(IllegalArgumentException | NullPointerException n){
                    System.out.println("ERROR: " + INVALID_INPUT);
            }catch (IllegalStateException s)
            {
                break;
            }
        }
        DBConnector.close();
    }

    private static void getExercises(ExerciseController exercises, Scanner scanner) {
        while (true) {
            System.out.println(BACK_COMMAND);
            exercises.infoText();
            String input = scanner.nextLine();
            if (input.equalsIgnoreCase("Back")) {
                break;
            }

            if(input.equalsIgnoreCase("Stop")){
                throw new IllegalStateException();
            }

            try {
                int pick = Integer.parseInt(input);
                String exerciseName = exercises.getExerciseName(pick);
                if (exerciseName == null) {
                    throw new IllegalArgumentException(INVALID_INPUT);
                }
                System.out.printf("Selected exercise is %S.%n", exerciseName);
                System.out.println(SEPARATOR);
                exercises.getExercise(pick).run(DBConnector.getConnection());
                System.out.println(SEPARATOR);
            } catch (NumberFormatException | NullPointerException e) {
                System.out.println("ERROR:" + INVALID_INPUT);
            } catch (IllegalArgumentException s) {
                System.out.println("ERROR:  " + s.getMessage());
            }
        }
    }
}
