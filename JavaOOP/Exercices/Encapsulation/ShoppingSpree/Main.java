package JavaOOP.Exercises.Encapsulation.ShoppingSpree;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        DataBase dataBase = new DataBase();
        try{
        fillPersons(scanner, dataBase);
        fillProductPrices(scanner,dataBase);
        }catch (IllegalStateException e){
            System.out.println(e.getMessage());
            return;
        }
        fillBag(scanner,dataBase);
        dataBase.printResult();
    }

    private static void fillBag(Scanner scanner, DataBase dataBase) {
        while(true) {
            String input = scanner.nextLine();
            if (input.equals("END")) {
                break;
            }
            String[] tokens = input.split(" ");
            String personName = tokens[0];
            String productName = tokens[1];
            try {
                dataBase.addProductToPerson(personName, productName);
                System.out.printf("%s bought %s\n", personName, productName);
            } catch (IllegalStateException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private static void fillProductPrices(Scanner scanner, DataBase dataBase) {
        String [] products = scanner.nextLine().split(";");
        for (String product : products) {
            String [] tokens = product.split("=");
            String productName = tokens[0];
            double productCost = Double.parseDouble(tokens[1]);

                dataBase.addProductToPriceList(productName,productCost);
        }
    }

    private static void fillPersons(Scanner scanner, DataBase dataBase) {
        String [] Persons = scanner.nextLine().split(";");
        for (String person : Persons) {
            String [] token = person.split("=");
            String personName = token[0];
            double money = Double.parseDouble(token[1]);
                dataBase.addUser(personName,money);
        }

    }
}
