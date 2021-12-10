package Exercices.Polymorphism.wildFarm;

public class Zebra extends Mammal{
    public Zebra(String animalType, String animalName, Double animalWeight, String livingRegion) {
        super(animalType, animalName, animalWeight, livingRegion);
    }
    @Override
    public void makeSound() {
        System.out.println("Zs");
    }
}
