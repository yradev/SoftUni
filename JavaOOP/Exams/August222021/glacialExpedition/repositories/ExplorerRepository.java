package Exams.August222021.glacialExpedition.repositories;

import Exams.August222021.glacialExpedition.models.explorers.Explorer;

import java.util.ArrayList;
import java.util.Collection;

public class ExplorerRepository implements Repository<Explorer>{
    private Collection<Explorer>explorers;

    public ExplorerRepository() {
        this.explorers = new ArrayList<>();
    }

    @Override
    public Collection<Explorer> getCollection() {
        return explorers;
    }

    @Override
    public void add(Explorer explorer) {
        explorers.add(explorer);
    }

    @Override
    public boolean remove(Explorer explorer) {
        return explorers.remove(explorer);
    }

    @Override
    public Explorer byName(String name) {
        for (Explorer explorer : explorers) {
            if(explorer.getName().equals(name)){
                return explorer;
            }
        }

        return null;
    }
}
