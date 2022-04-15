package Connector;

import org.hibernate.service.spi.ServiceException;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.Properties;
import java.util.Scanner;

import static Messages.CoreMessages.*;

public class DBConnector {
    private static EntityManager em;
    private static boolean isLogged;
    private static Properties props;
    private static String url;

    private DBConnector(){}

    public static void connect(){
        if(em == null && !isLogged){
            isLogged = false;
            Scanner scanner = new Scanner(System.in);
            System.out.print(ENTER_USERNAME);
            String userName = scanner.nextLine();
            System.out.print(ENTER_PASSWORD);
            String password = scanner.nextLine();
            System.out.print(ENTER_HOST);
            String host = scanner.nextLine();
            System.out.print(ENTER_PORT);
            String port = scanner.nextLine();
            validator(userName,password,host,port);
        }
    }

    private static void validator(String userName, String password, String host, String port) {
        try {
            url = "jdbc:mysql://" + host + ":" + port;
            Properties properties = new Properties();
            properties.setProperty("hibernate.connection.username", userName);
            properties.setProperty("hibernate.connection.password", password);
            properties.setProperty("hibernate.connection.url", url);
            Persistence.createEntityManagerFactory("connection", properties);
            props = properties;
            System.out.println(CONNECTED_TO_SERVER);
            System.out.println(PROGRAM_START);
            System.out.println("");
            isLogged = true;
        }catch (ServiceException es){
            System.out.println(NOT_CONNECTED_TO_SERVER);
        }
    }

    public static EntityManager getEntityManager() {
        if(em == null) {
            throw new IllegalArgumentException(DB_NOT_CONNECTED);
        }

        return em;
    }

    public static void connectToOtherDB(String DBName){
        if(em!=null) {
            em.close();
        }
        try {
            props.setProperty("hibernate.connection.url", url + "/" + DBName + "?createDatabaseIfNotExist=true");
            EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory(DBName, props);
            em = entityManagerFactory.createEntityManager();
            System.out.printf(DB_CONNECTED,DBName);
        }catch (ServiceException e){
            throw new IllegalArgumentException(e.getMessage());
        }
    }

    public static boolean isIsLogged() {
        return isLogged;
    }

    public static void close(){
        if(em!=null) {
            em.close();
        }
        System.out.println(DISCONNECTED_FROM_SERVER);
    }
}
