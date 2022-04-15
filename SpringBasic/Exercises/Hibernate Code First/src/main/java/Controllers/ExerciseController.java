package Controllers;

import Include.Exercises;

import java.util.LinkedHashMap;
import java.util.Map;

import static Messages.CoreMessages.*;
import static Messages.ExerciseMessages.*;

public class ExerciseController {
    private static Map<Integer,String> names;
    private static Map<Integer, Exercises> exercisesPathes;
    public static boolean isStarted;

    private ExerciseController(){}

    public static void run(){
        if(!isStarted) {
            isStarted = true;
            names = new LinkedHashMap<>();
            exercisesPathes = new LinkedHashMap<>();

            inputNames(
                    EXERCISE1,
                    EXERCISE2,
                    EXERCISE3,
                    EXERCISE4,
                    EXERCISE5
            );

            inputExercisesPathes(
                   new ExercisesLab.Gringotts_DataBase.Main(),
                    new ExercisesLab.Sales_Database.Main(),
                    new ExercisesLab.University_System.Main(),
                    new ExercisesLab.Hospital_Database.Main(),
                    new ExercisesLab.Bills_Payment_System.Main()
            );

        }

    }

    public static void infoText() {
        System.out.println(TYPE_INPUT);
        names.forEach((key, value) -> System.out.printf(INFO_TEXT, key, value));
        System.out.println();
        System.out.println(TYPE_STOP);
    }

    private static void inputNames(String ... values){
        int count = 1;
        for (String value : values) {
            names.put(count,value);
            count++;
        }
    }

    private static void inputExercisesPathes(Exercises... values){
        int count = 1;
        for (Exercises value : values) {
            exercisesPathes.put(count,value);
            count ++;
        }
    }

    public static Exercises getExercise(int Key){
        return exercisesPathes.get(Key);
    }
}
