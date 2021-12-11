package catHouse.entities.houses;

import catHouse.entities.cat.Cat;
import catHouse.entities.toys.Toy;

import java.util.ArrayList;
import java.util.Collection;
import java.util.stream.Collectors;

import static catHouse.common.ConstantMessages.*;
import static catHouse.common.ExceptionMessages.*;

public class BaseHouse implements House{
    private String name;
    private int capacity;
    private Collection<Toy>toys;
    private Collection<Cat>cats;

    public BaseHouse(String name, int capacity) {
        this.setName(name);
        this.capacity = capacity;
        toys = new ArrayList<>();
        cats = new ArrayList<>();
    }

    @Override
    public int sumSoftness() {
       return toys.stream().map(Toy::getSoftness).mapToInt(Integer::intValue).sum();
    }

    @Override
    public void addCat(Cat cat) {
        if(cats.size()>capacity){
            throw new IllegalStateException(NOT_ENOUGH_CAPACITY_FOR_CAT);
        }
        cats.add(cat);
    }

    @Override
    public void removeCat(Cat cat) {
        cats.remove(cat);
    }

    @Override
    public void buyToy(Toy toy) {
        toys.add(toy);
    }

    @Override
    public void feeding() {
        for (Cat cat : cats) {
            cat.eating();
        }
    }

    @Override
    public String getStatistics() {
        StringBuilder print = new StringBuilder();
        print.append(String.format("%s %s:",name,getClass().getSimpleName())).append(System.lineSeparator());
        print.append(cats.isEmpty()
        ? "Cats: none"
        : String.format("Cats: %s",cats.stream().map(Cat::getName).collect(Collectors.joining(" ")))).append(System.lineSeparator());
        print.append(String.format("Toys: %s Softness: %s",toys.size(),toys.stream().map(Toy::getSoftness).mapToInt(Integer::intValue).sum()));
        return print.toString();
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        if(name==null || name.trim().isEmpty()){
            throw new NullPointerException(HOUSE_NAME_CANNOT_BE_NULL_OR_EMPTY);
        }

        this.name = name;
    }

    @Override
    public Collection<Cat> getCats() {
        return cats;
    }

    @Override
    public Collection<Toy> getToys() {
        return toys;
    }
}
