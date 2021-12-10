package JavaOOP.Exercises.Encapsulation.PizzaCalories;

public class Topping {
    private String toppingType;
    private double weight;

    public Topping(String toppingType, double weight) {
        setToppingType(toppingType);
        setWeight(weight);
    }

    private void setToppingType(String toppingType) {
        Validator.toppingTypes(toppingType);
        this.toppingType = toppingType;
    }

    private void setWeight(double weight) {
        Validator.toppingWight(toppingType,weight);
        this.weight = weight;
    }

    private double getModifier(String name){
        double value = 0;
        switch (name){
            case"Meat": value=1.2;break;
            case"Veggies": value=0.8;break;
            case"Cheese": value=1.1;break;
            case"Sauce":value=0.9;break;
        }
       return value;
    }

    public double calculateCalories(){
        return (2*weight)*getModifier(toppingType);
    }
}
