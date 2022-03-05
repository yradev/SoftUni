package controller;

import org.hibernate.service.spi.ServiceException;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.Properties;
import java.util.Scanner;

import static messages.CoreMessages.*;

public class DBConnector {
   private static EntityManager em;
   public static boolean isLogged;

   private DBConnector(){}

    public static void connect(){
       if(em == null){
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
           String url = "jdbc:mysql://" + host + ":" + port + "/soft_uni?createDatabaseIfNotExist=true";
           Properties properties = new Properties();
           properties.setProperty("hibernate.connection.username", userName);
           properties.setProperty("hibernate.connection.password", password);
           properties.setProperty("hibernate.connection.url", url);
           EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("soft_uni", properties);
           em = entityManagerFactory.createEntityManager();
           System.out.println(DB_CONNECTED);
           System.out.println(PROGRAM_START);
           System.out.println("");
           isLogged = true;
       }catch (ServiceException es){
           System.out.println(DB_NOT_CONNECTED);
       }
    }

    public static EntityManager getEntityManager() {
        return em;
    }

    public static void close(){
       em.close();
       System.out.println(DB_DISCONNECTED);
    }
}
