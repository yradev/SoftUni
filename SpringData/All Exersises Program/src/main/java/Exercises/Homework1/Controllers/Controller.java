package Exercises.Homework1.Controllers;

import Include.ExerciseController;
import Exercises.Homework1.*;
import java.sql.Connection;

import static Messages.CoreMessages.*;
import static Messages.Homework1_Messages.*;

public class Controller extends ExerciseController {

    public Controller(Connection connection) {
        super(connection);
        super.inputNames(
                EXERCISE1,
                EXERCISE2,
                EXERCISE3,
                EXERCISE4,
                EXERCISE5,
                EXERCISE6,
                EXERCISE7,
                EXERCISE8,
                EXERCISE9
        );
        super.inputExercisesPathes(
                new Exercise1(),
                new Exercise2(),
                new Exercise3(),
                new Exercise4(),
                new Exercise5(),
                new Exercise6(),
                new Exercise7(),
                new Exercise8(),
                new Exercise9()
        );
    }

    @Override
    public void infoText() {
        System.out.print(EXERCISE_TEST);
        super.infoText();
    }
}
