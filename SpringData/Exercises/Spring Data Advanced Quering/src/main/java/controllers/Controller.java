package controllers;
import java.util.Scanner;

import static messages.CoreMessages.*;

public class Controller {
    private static Scanner scanner;

    public static void run(){
        ExerciseController.importValues();

        while(true) {
            System.out.println(TYPE_INPUT);
            ExerciseController.getExercisesInfo();
            System.out.println(TYPE_STOP);
            String input = new Scanner(System.in).nextLine();
            if(input.equalsIgnoreCase("Stop")){
                break;
            }

            int pick;
            try {
                pick = Integer.parseInt(input);
                ExerciseController.run(pick);
                System.out.println();
            }catch (IllegalStateException e){
                System.out.printf("ERROR: %s\n",e.getMessage());
            }catch (NullPointerException | NumberFormatException e){
                System.out.printf("ERROR: %s\n",INVALID_INPUT);
            }
        }
    }
}
