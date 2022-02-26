package Controllers;

import Include.ExerciseController;

import java.sql.Connection;

import static Messages.CoreMessages.*;
import static Messages.HomeworkNames.*;

public class HomeworksController extends ExerciseController {
    public HomeworksController(Connection connection) {
        super(connection);
        super.inputNames(HOMEWORK1,HOMEWORK2);
        super.inputHomeworkPathes(
                new Exercises.Homework1.Controllers.Controller(connection),
                new Exercises.Homework2.Controller.Controller(connection)
        );
    }

    @Override
    public void infoText() {
        System.out.print(STOP_COMMAND);
        System.out.println(PICK_EXERCISES_GROUP);
        System.out.println();
        super.infoText();
    }
}