package Polymorphism.VehiclesExtension;

import java.text.DecimalFormat;

public abstract class Vehicles {
   private double fuelQuantity;
   private double fuelConsumptioninLitersPerKm;
   private double fuelCapacity;

    public Vehicles(double fuelQuantity, double fuelConsumptioninLitersPerKm, double fuelCapacity) {
        this.fuelQuantity = fuelQuantity;
        this.fuelConsumptioninLitersPerKm = fuelConsumptioninLitersPerKm;
        this.fuelCapacity = fuelCapacity;
    }

    public String Drive(double distance){
        if(fuelQuantity>=distance*fuelConsumptioninLitersPerKm){
            fuelQuantity-=distance*fuelConsumptioninLitersPerKm;
            DecimalFormat dec = new DecimalFormat("#.##");
            return String.format("%s travelled %s km",getClass().getSimpleName(),dec.format(distance));
        }
        return String.format("%s needs refueling",getClass().getSimpleName());
    }

    public String DriveEmpty(double distance){
        double tempfuelConsumptioninLitersPerKm = fuelConsumptioninLitersPerKm-1.4;
        if(fuelQuantity>=distance*tempfuelConsumptioninLitersPerKm){
            fuelQuantity-=distance*tempfuelConsumptioninLitersPerKm;
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

    public boolean isValid(double value){
        return fuelQuantity + value <= fuelCapacity;
    }

    @Override
    public String toString() {
        return String.format("%s: %.2f",getClass().getSimpleName(),fuelQuantity);
    }
}
