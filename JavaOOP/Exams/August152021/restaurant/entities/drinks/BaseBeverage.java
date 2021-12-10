package Exams.August152021.restaurant.entities.drinks;

import Exams.August152021.restaurant.entities.drinks.interfaces.Beverages;

import static Exams.August152021.restaurant.common.ExceptionMessages.*;

public class BaseBeverage implements Beverages {
    private String name;
    private int counter;
    private double price;
    private String brand;

    public BaseBeverage(String name, int counter, double price, String brand) {
        this.setName(name);
        this.setCounter(counter);
        this.setPrice(price);
        this.setBrand(brand);
    }

    public void setBrand(String brand) {
        if(brand == null || brand.trim().isEmpty()){
            throw new IllegalArgumentException(INVALID_BRAND);
        }
        this.brand = brand;
    }

    public void setPrice(double price) {
        if(price<=0){
            throw new IllegalArgumentException(INVALID_PRICE);
        }
        this.price = price;
    }

    private void setCounter(int counter) {
        if(counter<=0){
            throw new IllegalArgumentException(INVALID_COUNTER);
        }
        this.counter = counter;
    }

    private void setName(String name) {
        if(name == null || name.trim().isEmpty()){
            throw new IllegalArgumentException(INVALID_NAME);
        }
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getCounter() {
        return counter;
    }

    @Override
    public double getPrice() {
        return price;
    }

    @Override
    public String getBrand() {
        return brand;
    }
}
