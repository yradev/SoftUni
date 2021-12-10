package Exercices.Polymorphism.wildFarm;

public class Checker {
    public static boolean Check(String foodType, String animalType){
        switch (foodType){
            case"Meat":
                if(animalType.equals("Zebra")){
                    throw new IllegalStateException(String.format("%ss are not eating that type of food!",animalType));
                }
                if(animalType.equals("Mouse")){
                    throw new IllegalStateException("Mice are not eating that type of food!");

                }
                break;

            case"Vegetable":
                if(animalType.equals("Tiger")){
                    throw new IllegalStateException(String.format("%ss are not eating that type of food!",animalType));
                }
                break;
        }
        return true;
    }
}
