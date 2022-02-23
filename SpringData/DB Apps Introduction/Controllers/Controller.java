package Controllers;

import Connector.DBConnector;

import java.util.Scanner;

import static Include.CoreMessages.*;


public class Controller {
    public static void run() {
        Scanner scanner = new Scanner(System.in);
        DBConnector dataBase = new DBConnector();
        String input;

        while(true) {
            ExerciseController exercises = new ExerciseController(dataBase.getConnection());
            exercises.infoText();
            input = scanner.nextLine();
            if(input.equalsIgnoreCase("stop")){
                break;
            }
            try {
                int pick = Integer.parseInt(input);

                System.out.printf("Selected exercise is %S.%n", exercises.getExerciseName(pick));
                System.out.println(SEPARATOR);
                try {
                    exercises.getExercise(pick).run(dataBase.getConnection());
                } catch (IllegalArgumentException e) {
                    System.out.println("ERROR: " + e.getMessage());
                }
                System.out.println(SEPARATOR);
            }catch (NumberFormatException e){
                System.out.println(INVALID_NUMBER_PICK);
            }
        }
        dataBase.close();
    }
}
