package Homeworks.Introduction_to_Hibernate.Controller;

import Include.ExerciseController;

import java.sql.Connection;

public class Controller extends ExerciseController {

    public Controller(Connection connection) {
        super(connection);
    }
}
