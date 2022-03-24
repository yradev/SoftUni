package products_shop.Services;

import java.io.FileNotFoundException;

public interface SeedService {
    void seedUsers() throws FileNotFoundException;
    void seedCategories() throws FileNotFoundException;
    void seedProducts() throws FileNotFoundException;

    default void seedData() throws FileNotFoundException {
        try {
            seedUsers();
        }catch (IllegalStateException e){
            System.out.println(e.getMessage());
        }

        try {
            seedCategories();
        }catch (IllegalStateException e){
            System.out.println(e.getMessage());
        }

        try {
            seedProducts();
        }catch (IllegalStateException e){
            System.out.println(e.getMessage());
        }
    }
}
