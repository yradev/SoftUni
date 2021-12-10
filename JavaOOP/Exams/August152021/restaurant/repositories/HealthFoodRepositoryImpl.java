package Exams.August152021.restaurant.repositories;

import Exams.August152021.restaurant.entities.healthyFoods.interfaces.HealthyFood;

import java.util.ArrayList;
import java.util.Collection;

public class HealthFoodRepositoryImpl implements Exams.August152021.restaurant.repositories.interfaces.HealthFoodRepository<HealthyFood> {
    private Collection<HealthyFood> entities;

    public HealthFoodRepositoryImpl() {
        entities = new ArrayList<>();
    }

    @Override
    public HealthyFood foodByName(String name) {
        return entities.stream().filter(a->a.getName().equals(name)).findFirst().orElse(null);
    }

    @Override
    public Collection<HealthyFood> getAllEntities() {
        return entities;
    }

    @Override
    public void add(HealthyFood entity) {
        entities.add(entity);
    }
}
