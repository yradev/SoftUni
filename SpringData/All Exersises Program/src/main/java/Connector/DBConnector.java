package Connector;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;
import java.util.Scanner;

import static Messages.CoreMessages.*;


public class DBConnector {
    private static Connection connection;

    private DBConnector(){}

    public static void connect() {
        if(connection == null) {
           Scanner scanner = new Scanner(System.in);
            System.out.print(ENTER_USERNAME);
            String userName = scanner.nextLine();
            System.out.print(ENTER_PASSWORD);
            String password = scanner.nextLine();
            System.out.print(ENTER_HOST);
            String host = scanner.nextLine();
            System.out.print(ENTER_PORT);
            int port = Integer.parseInt(scanner.nextLine());
            DBConnector.validator(userName, password, host, port);
        }else{
            throw new IllegalStateException(DB_IS_CONNECTED_ERROR);
        }
    }

    private static void validator (String userName, String password, String host, int port) {
        try {
            DBConnector.connector(userName,password,host,port);
            System.out.print(PROGRAM_START);
            System.out.println();
        }catch (SQLException e){
            if(e.getErrorCode()==1049){
                /* SQLException that we don't have minions_db in our database, now we will create `minions_db` and then return to validation */
                try {
                    Properties props = new Properties();
                    props.setProperty("user", userName);
                    props.setProperty("password", password);
                    DBConnector.connection = DriverManager.getConnection("jdbc:mysql://" + host + ":" + port, props);
                    PreparedStatement stmt = connection.prepareStatement("CREATE DATABASE minions_db;");
                    stmt.execute();
                    connection.close();
                    System.out.println(DB_MINIONS_CREATED);
                    validator(userName,password,host,port);
                }catch (SQLException a){
                    System.out.println(a.getMessage());
                }
            }

            else if(e.getErrorCode()==1045){
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
        DBConnector.connection = DriverManager.getConnection("jdbc:mysql://" + host + ":" + port + "/minions_db", props);
        System.out.println(DB_CONNECTED);
    }

    public static Connection getConnection() {
        return connection;
    }

    public static void close(){
        try{
        DBConnector.connection.close();
            System.out.println(DB_DISCONNECTED);
        }catch (SQLException e){
                System.out.println(e.getMessage());
        }
    }
}