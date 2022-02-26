package Exercises.Homework1.Controllers;

import Include.ExerciseController;
import Exercises.Homework1.*;
import Include.ExercisesImp;

import java.sql.Connection;
import java.util.Map;

import static Messages.CoreMessages.*;
import static Messages.Homework1_Messages.*;

public class Controller extends ExerciseController {

    public Controller(Connection connection) {
        super(connection);
        inputValues();
    }

    @Override
    public void infoText() {
        System.out.print(EXERCISE_TEST);
        super.infoText();
    }

    @Override
    public ExercisesImp getExercise(int pick) {
        return super.getExercise(pick);
    }

    @Override
    public String getExerciseName(int pick) {
        return super.getExerciseName(pick);
    }

    @Override
    public Map<Integer, String> getExerciseNames() {
        return super.getExerciseNames();
    }

    protected void inputValues(){
           getExerciseNames().put(1,EXERCISE1);
           getExerciseNames().put(2,EXERCISE2);
           getExerciseNames().put(3,EXERCISE3);
           getExerciseNames().put(4,EXERCISE4);
           getExerciseNames().put(5,EXERCISE5);
           getExerciseNames().put(6,EXERCISE6);
           getExerciseNames().put(7,EXERCISE7);
           getExerciseNames().put(8,EXERCISE8);
           getExerciseNames().put(9,EXERCISE9);


           getExercisePathes().put(1, new Exercise1());
           getExercisePathes().put(2, new Exercise2());
           getExercisePathes().put(3, new Exercise3());
           getExercisePathes().put(4, new Exercise4());
           getExercisePathes().put(5, new Exercise5());
           getExercisePathes().put(6, new Exercise6());
           getExercisePathes().put(7, new Exercise7());
           getExercisePathes().put(8, new Exercise8());
           getExercisePathes().put(9, new Exercise9());
    }
}
