package Connector;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;
import java.util.Scanner;

import static Include.CoreMessages.*;


public class DBConnector {
    private static Connection connection;
    private static Scanner scanner;

    private DBConnector(){
    }

    public static void connect() {
        if(connection == null) {
            scanner = new Scanner(System.in);
            System.out.print(ENTER_USERNAME);
            String userName = scanner.nextLine();
            System.out.print(ENTER_PASSWORD);
            String password = scanner.nextLine();
            System.out.print(ENTER_HOST);
            String host = scanner.nextLine();
            System.out.print(ENTER_PORT);
            int port = Integer.parseInt(scanner.nextLine());
            validator(userName, password, host, port);
        }
    }

    private static void validator (String userName, String password, String host, int port) {
        try {
            connector(userName,password,host,port);
            System.out.print(PROGRAM_START);
        }catch (SQLException e){
            if(e.getErrorCode()==1045){
                System.out.println(INVALID_USERNAME_OR_PASSWORD);
            }
            else {
                System.out.println(e.getMessage());
            }
        }
    }

    private static void connector(String userName, String password, String host, int port) throws SQLException {
        Properties props = new Properties();
        props.setProperty("user", userName);
        props.setProperty("password", password);
        connection = DriverManager.getConnection("jdbc:mysql://" + host + ":" + port + "/minions_db?createDatabaseIfNotExist=true", props);
        System.out.println(DB_CONNECTED);
    }

    public static Connection getConnection() {
        return connection;
    }

    public static void close(){
        try{
        connection.close();
            System.out.println(DB_DISCONNECTED);
        }catch (SQLException e){
                System.out.println(e.getMessage());
        }
    }
}