package Polymorphism.Vehicles;

import java.text.DecimalFormat;

public abstract class Vehicles {
   private double fuelQuantity;
   private double fuelConsumptioninLitersPerKm;

    public Vehicles(double fuelQuantity, double fuelConsumptioninLitersPerKm) {
        this.fuelQuantity = fuelQuantity;
        this.fuelConsumptioninLitersPerKm = fuelConsumptioninLitersPerKm;
    }

    public String Drive(double distance){
        if(fuelQuantity>=distance*fuelConsumptioninLitersPerKm){
            fuelQuantity-=distance*fuelConsumptioninLitersPerKm;
            DecimalFormat dec = new DecimalFormat("#.##");
            return String.format("%s travelled %s km",getClass().getSimpleName(),dec.format(distance));
        }
        return String.format("%s needs refueling",getClass().getSimpleName());
    }

    public void Refuel(double liters){
        fuelQuantity+=liters;
    }
    public void setFuelConsumptioninLitersPerKm(double fuelConsumptioninLitersPerKm) {
        this.fuelConsumptioninLitersPerKm = fuelConsumptioninLitersPerKm;
    }

    public double getFuelConsumptioninLitersPerKm() {
        return fuelConsumptioninLitersPerKm;
    }

    @Override
    public String toString() {
        return String.format("%s: %.2f",getClass().getSimpleName(),fuelQuantity);
    }
}
