package JavaOOP.Exercises.Encapsulation.PizzaCalories;

import java.util.ArrayList;
import java.util.List;

public class Pizza {
    private String name;
    private Dough dough;
    private List<Topping> toppings;
    private int numberOfToppings;

    public Pizza(String name, int numberOfToppings) {
        setName(name);
        setToppings(numberOfToppings);
        toppings = new ArrayList<>();
    }

    private void setName(String name) {
        Validator.nameOfPizza(name);
        this.name = name;
    }

    public void setDough(Dough dought) {
        this.dough = dought;
    }

    public void addTopping(Topping topping){
        if (this.toppings.size() < this.numberOfToppings) {
            toppings.add(topping);
        }
    }

    private void setToppings(int numberOfToppings) {
        Validator.numberOfTopping(numberOfToppings);
        this.numberOfToppings = numberOfToppings;
    }

    public String getName() {
        return name;
    }

    public double getOverallCalories(){
        double sum = 0;
        sum+= dough.calculateCalories();
        for (Topping topping : toppings) {
            sum+=topping.calculateCalories();
        }
        return sum;
    }
}
