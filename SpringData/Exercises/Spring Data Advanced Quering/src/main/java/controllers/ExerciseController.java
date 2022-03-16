package controllers;

import com.example.springintro.exercises.Books_Titles_byAge_Restriction.Main;
import org.springframework.stereotype.Component;

import java.util.LinkedHashMap;
import java.util.Map;

import static messages.CoreMessages.*;

public class ExerciseController {
    private static Map<Integer,String> names;

    private ExerciseController() {}

    public static void importValues(){
        if(names == null) {
            names = new LinkedHashMap<>();
            inputNames(
                    EXERCISE1_NAME,
                    EXERCISE2_NAME,
                    EXERCISE3_NAME,
                    EXERCISE4_NAME,
                    EXERCISE5_NAME,
                    EXERCISE6_NAME,
                    EXERCISE7_NAME,
                    EXERCISE8_NAME,
                    EXERCISE9_NAME,
                    EXERCISE10_NAME,
                    EXERCISE11_NAME
            );
        }else{
            throw new IllegalStateException(DATA_ALREADY_IMPORTED);
        }
    }

    public static void run(int number){
        switch (number) {
            case 1 -> com.example.springintro.exercises.Books_Titles_byAge_Restriction.Main.run();
            case 2 -> com.example.springintro.exercises.Golden_Books.Main.run();
            case 3 -> com.example.springintro.exercises.Books_by_Price.Main.run();
            case 4 -> com.example.springintro.exercises.Not_Released_Books.Main.run();
            case 5 -> com.example.springintro.exercises.Books_Released_Before_Date.Main.run();
            case 6 -> com.example.springintro.exercises.Authors_Search.Main.run();
            case 7 -> com.example.springintro.exercises.Books_Search.Main.run();
            case 8 -> com.example.springintro.exercises.Book_Titles_Search.Main.run();
            case 9 -> com.example.springintro.exercises.Count_Books.Main.run();
            case 10 -> com.example.springintro.exercises.Total_Book_Copies.Main.run();
            case 11 -> com.example.springintro.exercises.Reduced_Book.Main.run();
            default -> throw new IllegalStateException(INVALID_INPUT);
        }
    }

    public static void getExercisesInfo() {
        if(names!=null){
            names.forEach((key, value) -> System.out.printf(INFO_TEXT, key, value));
            System.out.println();
        }
    }

    private static void inputNames(String ... values){
        int count = 1;
        for (String value : values) {
            names.put(count,value);
            count++;
        }
    }
}
