package Exams.April182021.spaceStation.models.astronauts;

import Exams.April182021.spaceStation.models.bags.Backpack;
import Exams.April182021.spaceStation.models.bags.Bag;

import static Exams.April182021.spaceStation.common.ExceptionMessages.*;

public class BaseAstronaut implements Astronaut{
    private String name;
    private double oxygen;
    private Bag bag;

    public BaseAstronaut(String name, double oxygen) {
        this.setName(name);
        this.setOxygen(oxygen);
        bag = new Backpack();
    }

    public void setOxygen(double oxygen) {
        if(oxygen<0){
            throw new IllegalArgumentException(ASTRONAUT_OXYGEN_LESS_THAN_ZERO);
        }
        this.oxygen = oxygen;
    }

    public void setName(String name) {
        if(name==null || name.trim().isEmpty()){
            throw new NullPointerException(ASTRONAUT_NAME_NULL_OR_EMPTY);
        }
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public double getOxygen() {
        return oxygen;
    }

    @Override
    public boolean canBreath() {
        return oxygen>0;
    }

    @Override
    public Bag getBag() {
        return bag;
    }

    @Override
    public void breath() {
        oxygen-=10;
        if(oxygen<0){
            oxygen=0;
        }
    }
}
