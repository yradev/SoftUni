package Polymorphism.VehiclesExtension;

public class Truck extends Vehicles{
    public Truck(double fuelQuantity, double fuelConsumptioninLitersPerKm, double fuelCapacity) {
        super(fuelQuantity, fuelConsumptioninLitersPerKm, fuelCapacity);
        super.setFuelConsumptioninLitersPerKm(super.getFuelConsumptioninLitersPerKm()+1.6);
    }

    @Override
    public void Refuel(double liters) {
        super.Refuel(liters*95/100);
    }
}
