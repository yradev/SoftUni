package Exams.August152021.restaurant.entities.tables;

import Exams.August152021.restaurant.entities.drinks.interfaces.Beverages;
import Exams.August152021.restaurant.entities.healthyFoods.interfaces.HealthyFood;
import Exams.August152021.restaurant.entities.tables.interfaces.Table;

import java.util.ArrayList;
import java.util.Collection;

import static Exams.August152021.restaurant.common.ExceptionMessages.INVALID_NUMBER_OF_PEOPLE;
import static Exams.August152021.restaurant.common.ExceptionMessages.INVALID_TABLE_SIZE;

public class BaseTable implements Table {
    private Collection<HealthyFood> healthyFood;
    private Collection<Beverages>beverages;
    private int number;
    private int size;
    private int numberOfPeople;
    private double pricePerPerson;
    private boolean isReservedTable;
    private double allPeople;

    public BaseTable(int number, int size, double pricePerPerson) {
        this.number = number;
        this.setSize(size);
        this.pricePerPerson = pricePerPerson;
        healthyFood = new ArrayList<>();
        beverages = new ArrayList<>();
    }


    public void setNumberOfPeople(int numberOfPeople) {
        if(numberOfPeople<=0){
            throw new IllegalArgumentException(INVALID_NUMBER_OF_PEOPLE);
        }
        this.numberOfPeople = numberOfPeople;
    }

    public void setSize(int size) {
        if(size<0){
            throw new IllegalArgumentException(INVALID_TABLE_SIZE);
        }
        this.size = size;
    }

    @Override
    public int getTableNumber() {
        return number;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public int numberOfPeople() {
        return numberOfPeople;
    }

    @Override
    public double pricePerPerson() {
        return pricePerPerson;
    }

    @Override
    public boolean isReservedTable() {
        return isReservedTable;
    }

    @Override
    public double allPeople() {
        return allPeople;
    }

    @Override
    public void reserve(int numberOfPeople) {
        setNumberOfPeople(numberOfPeople);
        isReservedTable=true;
    }

    @Override
    public void orderHealthy(HealthyFood food) {
        healthyFood.add(food);
    }

    @Override
    public void orderBeverages(Beverages beverage) {
        beverages.add(beverage);
    }

    @Override
    public double bill() {
        this.allPeople=numberOfPeople*pricePerPerson
        +healthyFood.stream().mapToDouble(HealthyFood::getPrice).sum()
        +beverages.stream().mapToDouble(Beverages::getPrice).sum();
        return this.allPeople;
    }

    @Override
    public void clear() {
        healthyFood.clear();
        beverages.clear();
        numberOfPeople = 0;
        allPeople = 0;
        isReservedTable = false;
    }

    @Override
    public String tableInformation() {
        String print = String.format("Table - %s", number) + System.lineSeparator() +
                String.format("Size - %s", size) + System.lineSeparator() +
                String.format("Type - %s", getClass().getSimpleName()) + System.lineSeparator() +
                String.format("All price - %.2f", pricePerPerson) + System.lineSeparator();
        return print.trim();
    }
}
