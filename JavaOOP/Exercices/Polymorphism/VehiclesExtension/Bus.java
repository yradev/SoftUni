package Polymorphism.VehiclesExtension;

public class Bus extends Vehicles{
    public Bus(double fuelQuantity, double fuelConsumptioninLitersPerKm, double fuelCapacity) {
        super(fuelQuantity, fuelConsumptioninLitersPerKm, fuelCapacity);
        super.setFuelConsumptioninLitersPerKm(super.getFuelConsumptioninLitersPerKm()+1.4);
    }
}
