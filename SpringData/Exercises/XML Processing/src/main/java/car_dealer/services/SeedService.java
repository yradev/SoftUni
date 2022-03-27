package car_dealer.services;

import javax.xml.bind.JAXBException;
import java.io.FileNotFoundException;

public interface SeedService {
    void seedSuppliers() throws FileNotFoundException, JAXBException;
    void seedParts() throws FileNotFoundException, JAXBException;
    void seedCars() throws FileNotFoundException, JAXBException;
    void seedCustomers() throws FileNotFoundException, JAXBException;
    void seedSales();
    default void seedData() throws FileNotFoundException, JAXBException {
        seedSuppliers();
        seedParts();
        seedCars();
        seedCustomers();
        seedSales();
    }
}
