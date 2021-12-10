package Exams.August152021.restaurant.repositories;

import Exams.August152021.restaurant.entities.drinks.interfaces.Beverages;

import java.util.ArrayList;
import java.util.Collection;

public class BeverageRepositoryImpl implements Exams.August152021.restaurant.repositories.interfaces.BeverageRepository<Beverages> {
    private Collection<Beverages> entities;

    public BeverageRepositoryImpl() {
        entities = new ArrayList<>();
    }

    @Override
    public Beverages beverageByName(String drinkName, String drinkBrand) {
        return entities.stream()
                .filter(a->a.getName().equals(drinkName) && a.getBrand().equals(drinkBrand))
                .findFirst()
                .orElse(null);
    }

    @Override
    public Collection<Beverages> getAllEntities() {
        return entities;
    }

    @Override
    public void add(Beverages entity) {
        entities.add(entity);
    }
}
