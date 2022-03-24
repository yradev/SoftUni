package car_dealer.services;

import java.io.FileNotFoundException;

public interface SeedService {
    void seedSuppliers() throws FileNotFoundException;
    void seedParts() throws FileNotFoundException;
    void seedCars() throws FileNotFoundException;
    void seedCustomers() throws FileNotFoundException;
    void seedSales();
    default void seedData() throws FileNotFoundException {
        seedSuppliers();
        seedParts();
        seedCars();
        seedCustomers();
        seedSales();
    }
}
