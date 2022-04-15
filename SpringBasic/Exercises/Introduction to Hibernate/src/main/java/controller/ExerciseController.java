package controller;

import include.ExercisesInterface;

import java.util.LinkedHashMap;
import java.util.Map;

import static messages.CoreMessages.*;
import static messages.ExerciseMessages.*;

public class ExerciseController {
    private static Map<Integer,String> names;
    private static Map<Integer, ExercisesInterface> exercisesPathes;
    private static boolean isStarted;

    private ExerciseController(){}

    public static void run(){
        if(!isStarted) {
            isStarted = true;
            names = new LinkedHashMap<>();
            exercisesPathes = new LinkedHashMap<>();

            inputNames(
                    EXERCISE2,
                    EXERCISE3,
                    EXERCISE4,
                    EXERCISE5,
                    EXERCISE6,
                    EXERCISE7,
                    EXERCISE8,
                    EXERCISE9,
                    EXERCISE10,
                    EXERCISE11,
                    EXERCISE12,
                    EXERCISE13
            );

            inputExercisesPathes(
                    new exercises.Change_casing.Main(),
                    new exercises.Contains_Employee.Main(),
                    new exercises.Employees_with_Salary_Over_50000.Main(),
                    new exercises.Employees_from_Department.Main(),
                    new exercises.Adding_a_New_Address_and_Updating_Employee.Main(),
                    new exercises.Addresses_with_Employee_Count.Main(),
                    new exercises.Get_Employee_with_Project.Main(),
                    new exercises.Find_Latest_10_Projects.Main(),
                    new exercises.Increase_Salaries.Main(),
                    new exercises.Find_Employees_by_First_Name.Main(),
                    new exercises.Employees_Maximum_Salaries.Main(),
                    new exercises.Remove_Towns.Main()
            );

        }

    }

    public static void infoText() {
        System.out.println(TYPE_INPUT);
        names.forEach((key, value) -> System.out.printf(INFO_TEXT, key, value));
        System.out.println();
    }

    private static void inputNames(String ... values){
        int count = 2;
        for (String value : values) {
            names.put(count,value);
            count++;
        }
    }

    private static void inputExercisesPathes(ExercisesInterface ... values){
        int count = 2;
        for (ExercisesInterface value : values) {
            exercisesPathes.put(count,value);
            count ++;
        }
    }

    public static ExercisesInterface getExercise(int Key){
        return exercisesPathes.get(Key);
    }
}
