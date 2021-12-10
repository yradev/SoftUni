package Exams.April182021.spaceStation.models.planets;

import java.util.ArrayList;
import java.util.Collection;

import static Exams.April182021.spaceStation.common.ExceptionMessages.PLANET_NAME_NULL_OR_EMPTY;

public class PlanetImpl implements Planet{
    private String name;
    private Collection<String>items;

    public PlanetImpl(String name) {
        this.setName(name);
        items = new ArrayList<>();
    }

    private void setName(String name) {
        if(name==null || name.trim().isEmpty()){
            throw new NullPointerException(PLANET_NAME_NULL_OR_EMPTY);
        }
        this.name = name;
    }

    @Override
    public Collection<String> getItems() {
        return items;
    }

    @Override
    public String getName() {
        return name;
    }
}
