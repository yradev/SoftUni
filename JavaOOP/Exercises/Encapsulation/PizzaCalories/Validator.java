package JavaOOP.Exercises.Encapsulation.PizzaCalories;

import java.util.List;

public class Validator {
    public static void numberOfTopping(int numberOfTopping){
        if(numberOfTopping<1 || numberOfTopping>10){
            throw new IllegalStateException("Number of toppings should be in range [0..10].");
        }
    }

    public static void nameOfPizza(String name){
        if (name == null || name.trim().length() < 1 || name.trim().length() > 15) {
            throw new IllegalStateException("Pizza name should be between 1 and 15 symbols.");
        }
    }

    public static void toppingWight(String toppyngTypeName, double weight){
        if(weight<1 || weight>50){
            throw new IllegalStateException(String.format("%s weight should be in the range [1..50].",toppyngTypeName));
        }
    }

    public static void toppingTypes(String toppyingType){
        List<String> toppyingTypesList = List.of("Meat","Veggies","Cheese","Sauce");
        if(!toppyingTypesList.contains(toppyingType)){
            throw new IllegalStateException(String.format("Cannot place %s on top of your pizza.",toppyingType));
        }
    }

    public static void doughWeigh(double weight){
        if(weight<1 || weight>200){
            throw new IllegalStateException("Dough weight should be in the range [1..200].");
        }
    }

    public static void flourType(String type) {
        List<String> flourTypeList = List.of("White","Wholegrain");
        if (!flourTypeList.contains(type)) {
            throw new IllegalStateException("Invalid type of dough.");
        }
    }

    public static void bakingTechnique(String bakingTechnique) {
        List<String> bakingTechniqueList = List.of("Crispy","Chewy","Homemade");
        if (!bakingTechniqueList.contains(bakingTechnique)) {
            throw new IllegalStateException("Invalid type of dough.");
        }
    }
}
