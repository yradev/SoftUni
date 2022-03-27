package products_shop.Services;

import javax.xml.bind.JAXBException;
import java.io.FileNotFoundException;

public interface SeedService {
    void seedUsers() throws FileNotFoundException, JAXBException;
    void seedCategories() throws FileNotFoundException, JAXBException;
    void seedProducts() throws FileNotFoundException, JAXBException;

    default void seedAllData() throws FileNotFoundException, JAXBException {
        seedUsers();
        seedCategories();
        seedProducts();
    }
}
