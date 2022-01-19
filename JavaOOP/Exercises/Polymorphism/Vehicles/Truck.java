package Polymorphism.Vehicles;

public class Truck extends Vehicles{
    public Truck(double fuelQuantity, double fuelConsumptioninLitersPerKm) {
        super(fuelQuantity, fuelConsumptioninLitersPerKm);
        super.setFuelConsumptioninLitersPerKm(super.getFuelConsumptioninLitersPerKm()+1.6);
    }

    @Override
    public void Refuel(double liters) {
        super.Refuel(liters*95/100);
    }
}
