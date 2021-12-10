package Reflеction.barracksWars.core.commands;

import Reflеction.barracksWars.interfaces.Executable;
import Reflеction.barracksWars.interfaces.Repository;
import Reflеction.barracksWars.interfaces.UnitFactory;

public abstract class Command implements Executable {
    private String[] data;
    private Repository repository;
    private UnitFactory unitFactory;

    public Command(String[] data, Repository repository, UnitFactory unitFactory) {
        this.data = data;
        this.repository = repository;
        this.unitFactory = unitFactory;
    }

    public Repository getRepository() {
        return repository;
    }

    public UnitFactory getUnitFactory() {
        return unitFactory;
    }

    public String[] getData(){
        return data;
    }
}
