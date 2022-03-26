package products_shop.Services;

import java.io.FileNotFoundException;

public interface SeedService {
    void seedUsers() throws FileNotFoundException;
    void seedCategories() throws FileNotFoundException;
    void seedProducts() throws FileNotFoundException;

    default void seedAllData() throws FileNotFoundException {
        seedUsers();
        seedCategories();
        seedProducts();
    }
}
