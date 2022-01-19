package Exercices.Polymorphism.wildFarm;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Animal> animalList = new ArrayList<>();
        while(true) {
            String input = scanner.nextLine();
            if(input.equals("End")){
                break;
            }
            Animal animal = setAnimal(input);
            Food food = setFood(scanner);
            animal.makeSound();
            try {
                Checker.Check(food.getClass().getSimpleName(), animal.getAnimalType());
                animal.eatFood(food);
            } catch (IllegalStateException e) {
                System.out.println(e.getMessage());
            }
            animalList.add(animal);
        }

        animalList.forEach(System.out::println);
    }

    private static Food setFood(Scanner scanner) {
        String [] input = scanner.nextLine().split(" ");
        String foodName = input[0];
        int foodQuantity = Integer.parseInt(input[1]);
        return foodName.equals("Meat")
                ? new Meat(foodQuantity)
                : new Vegetable(foodQuantity);
    }

    private static Animal setAnimal(String input) {
        String[]tokens = input.split(" ");
        String animalType = tokens[0];
        String animalName = tokens[1];
        Double animalWeight = Double.parseDouble(tokens[2]);
        String animalLivingRegion = tokens[3];

        switch (animalType){
            case"Cat":
                return new Cat(animalType, animalName, animalWeight, animalLivingRegion, tokens[4]);
            case"Zebra":
                return new Zebra(animalType, animalName, animalWeight, animalLivingRegion);
            case"Mouse":
                return new Mouse(animalType, animalName, animalWeight, animalLivingRegion);
            case"Tiger":
               return new Tiger(animalType, animalName, animalWeight, animalLivingRegion);
            default:
                throw new IllegalArgumentException("Unknown animal type " + tokens[0]);
        }
    }
}
