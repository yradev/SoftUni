package Exams.August152021.restaurant.entities.healthyFoods;

import Exams.August152021.restaurant.entities.healthyFoods.interfaces.HealthyFood;

import static Exams.August152021.restaurant.common.ExceptionMessages.*;

public class Food implements HealthyFood {
    private String name;
    private double portion;
    private double price;

    public Food(String name, double portion, double price) {
        this.setName(name);
        this.setPortion(portion);
        this.setPrice(price);
    }

    @Override
    public String getName() {
        return name;
    }

    private void setName(String name) {
        if(name == null || name.trim().isEmpty()){
            throw new IllegalArgumentException(INVALID_NAME);
        }
        this.name = name;
    }

    private void setPortion(double portion) {
        if(portion<=0){
            throw new IllegalArgumentException(INVALID_PORTION);
        }
        this.portion = portion;
    }

    public void setPrice(double price) {
        if(price<=0){
            throw new IllegalArgumentException(INVALID_PRICE);
        }
        this.price = price;
    }

    @Override
    public double getPortion() {
        return portion;
    }

    @Override
    public double getPrice() {
        return price;
    }
}
