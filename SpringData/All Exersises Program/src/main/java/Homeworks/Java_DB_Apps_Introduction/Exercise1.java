package Homeworks.Java_DB_Apps_Introduction;

import Include.ExercisesImp;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.*;
import java.util.Scanner;

import static Messages.Java_DB_Apps_Introduction_Messages.*;

public class Exercise1 implements ExercisesImp {
    private FileInputStream inputStream;
    private Scanner scanner;
    private Connection connection;
    @Override
    public void run(Connection connection) {
        this.connection = connection;
        if(checker()) {
            importFromFile();
            importToMysql(connection);
            System.out.println(SQL_FILE_IMPORTED);
        }else{
            System.out.println(DB_NOT_EMPTY);
        }
   }

    private void importToMysql(Connection connection) {
        while (scanner.hasNext()) {
            try {
                PreparedStatement stmt = connection.prepareStatement(scanner.nextLine());
                stmt.execute();
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private boolean checker(){
        try{
            PreparedStatement statement = connection.prepareStatement("SELECT `id` FROM `towns`");
            statement.execute();
            return false;
        }catch (SQLException e){
            return  true;
        }
    }

    private void importFromFile(){
        try {
            inputStream = new FileInputStream(System.getProperty("user.dir") + MINIONS_DB_PATH);
            scanner = new Scanner(inputStream);
        } catch (FileNotFoundException e) {
            throw new IllegalArgumentException(e.getMessage());
        }
    }
}