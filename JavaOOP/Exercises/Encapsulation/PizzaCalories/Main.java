package JavaOOP.Exercises.Encapsulation.PizzaCalories;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        try {
            Pizza pizza = fillPizzaClass(scanner);
            pizza.setDough(fillDoughClasss(scanner));
            fillTopping(scanner,pizza);
            System.out.printf("%s - %.2f",pizza.getName(),pizza.getOverallCalories());
        }catch (IllegalStateException e){
            System.out.println(e.getMessage());
        }
    }

    private static void fillTopping(Scanner scanner, Pizza pizza) {
        while(true){
            String input = scanner.nextLine();
            if(input.equals("END")){
                break;
            }

            String [] tokens = input.split(" ");
                String toppingType = tokens[1];
                double weightInGrams = Double.parseDouble(tokens[2]);
                Topping topping = new Topping(toppingType,weightInGrams);
                pizza.addTopping(topping);
        }
    }

    private static Dough fillDoughClasss(Scanner scanner) {
        String [] input = scanner.nextLine().split(" ");
        String flourType = input[1];
        String bakingTechnique = input[2];
        double weightInGrams = Double.parseDouble(input[3]);
        return new Dough(flourType,bakingTechnique,weightInGrams);
    }

    private static Pizza fillPizzaClass(Scanner scanner) {
        String [] input = scanner.nextLine().split(" ");
        String pizzaName = input[1];
        int numberOfToppings = Integer.parseInt(input[2]);
        return new Pizza(pizzaName,numberOfToppings);
    }
}
