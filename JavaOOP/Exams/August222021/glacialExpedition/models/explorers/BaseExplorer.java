package Exams.August222021.glacialExpedition.models.explorers;

import Exams.August222021.glacialExpedition.models.suitcases.Carton;
import Exams.August222021.glacialExpedition.models.suitcases.Suitcase;

import static Exams.August222021.glacialExpedition.common.ExceptionMessages.*;

public class BaseExplorer implements Explorer{
    private String name;
    private double energy;
    private Suitcase suitcase;

    public BaseExplorer(String name, double energy) {
        this.setName(name);
        this.energy = energy;
        suitcase = new Carton();
    }

    private void setName(String name) {
        if(name==null || name.trim().isEmpty()){
            throw new NullPointerException(EXPLORER_NAME_NULL_OR_EMPTY);
        }
        this.name = name;
    }

    protected void setEnergy(double energy) {
        if(energy<0){
            throw new IllegalArgumentException(EXPLORER_ENERGY_LESS_THAN_ZERO);
        }
        this.energy = energy;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public double getEnergy() {
        return energy;
    }

    @Override
    public boolean canSearch() {
        return energy>0;
    }

    @Override
    public Suitcase getSuitcase() {
        return suitcase;
    }

    @Override
    public void search() {
        energy-=15;
        if(energy<0){
            energy=0;
        }
    }
}
