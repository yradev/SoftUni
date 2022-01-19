package Polymorphism.VehiclesExtension;

public class Car extends Vehicles{
    public Car(double fuelQuantity, double fuelConsumptioninLitersPerKm, double fuelCapacity) {
        super(fuelQuantity, fuelConsumptioninLitersPerKm, fuelCapacity);
        super.setFuelConsumptioninLitersPerKm(super.getFuelConsumptioninLitersPerKm()+0.9);
    }
}
