package Exercices.Polymorphism.wildFarm;

import java.text.DecimalFormat;

public abstract class Mammal extends Animal{
    private String livingRegion;
    public Mammal(String animalType, String animalName, Double animalWeight, String livingRegion) {
        super(animalType, animalName, animalWeight);
        this.livingRegion = livingRegion;
    }

    public String getLivingRegion() {
        return livingRegion;
    }

    @Override
    public String toString() {
        DecimalFormat decimal = new DecimalFormat("#.##");
        return String.format("%s[%s, %s, %s, %d]",super.getAnimalType(),super.getAnimalName(),decimal.format(super.getAnimalWeight()),livingRegion,super.getFoodEaten());
    }
}
