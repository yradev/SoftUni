package controller;

import include.ExercisesInterface;

import java.util.Scanner;

import static messages.CoreMessages.INVALID_INPUT;

public class Controller {
    public static void run(){
           while(!DBConnector.isLogged) {
               DBConnector.connect();
           }

        ExerciseController.run();
        while(true) {
               ExerciseController.infoText();
               String pick = new Scanner(System.in).nextLine();
               if(pick.equalsIgnoreCase("Stop")){
                   DBConnector.close();
                   break;
               }
               try {
                  ExercisesInterface exercise =  ExerciseController.getExercise(Integer.parseInt(pick));
                   try {
                       if (exercise == null) {
                           throw new IllegalArgumentException(INVALID_INPUT);
                       }

                       exercise.run();
                   }catch (NumberFormatException e){
                       throw new IllegalArgumentException(INVALID_INPUT);
                   }
               } catch (IllegalArgumentException e) {
                   System.out.printf("Error: %s\n", e.getMessage());
               }
           }
    }
}
