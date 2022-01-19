package Polymorphism.Vehicles;

public class Car extends Vehicles{
    public Car(double fuelQuantity, double fuelConsumptioninLitersPerKm) {
        super(fuelQuantity, fuelConsumptioninLitersPerKm);
        super.setFuelConsumptioninLitersPerKm(super.getFuelConsumptioninLitersPerKm()+0.9);
    }
}
