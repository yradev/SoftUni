package Exercices.Polymorphism.wildFarm;

import java.text.DecimalFormat;

public class Cat extends Felime{
    private String breed;
    public Cat(String animalType, String animalName, Double animalWeight, String livingRegion, String breed) {
        super(animalType, animalName, animalWeight, livingRegion);
        this.breed = breed;
    }

    @Override
    public void makeSound() {
        System.out.println("Meowwww");
    }

    @Override
    public String toString() {
        DecimalFormat decimal = new DecimalFormat("#.##");
        return String.format("%s[%s, %s, %s, %s, %s]",super.getAnimalType(),super.getAnimalName(),breed,decimal.format(super.getAnimalWeight()),super.getLivingRegion(),super.getFoodEaten());
    }
}
