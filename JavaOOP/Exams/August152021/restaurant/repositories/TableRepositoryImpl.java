package Exams.August152021.restaurant.repositories;

import Exams.August152021.restaurant.entities.tables.interfaces.Table;

import java.util.ArrayList;
import java.util.Collection;

public class TableRepositoryImpl implements Exams.August152021.restaurant.repositories.interfaces.TableRepository<Table> {
    private Collection<Table>entities;

    public TableRepositoryImpl() {
        entities = new ArrayList<>();
    }

    @Override
    public Collection<Table> getAllEntities() {
        return entities;
    }

    @Override
    public void add(Table entity) {
        entities.add(entity);
    }

    @Override
    public Table byNumber(int number) {
        return entities.stream().filter(a->a.getTableNumber()==number).findFirst().orElse(null);
    }
}
