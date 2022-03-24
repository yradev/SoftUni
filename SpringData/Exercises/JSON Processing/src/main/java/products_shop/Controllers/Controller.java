package products_shop.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import products_shop.Services.ProductService;
import products_shop.Services.SeedService;
import products_shop.Services.UserService;

import static products_shop.Messages.Core.*;

@Component
public class Controller implements CommandLineRunner {
    private SeedService seedService;
    private ProductService productService;
    private UserService userService;

    @Autowired
    public Controller(SeedService seedService, ProductService productService, UserService userService) {
        this.seedService = seedService;
        this.productService = productService;
        this.userService = userService;
    }

    @Override
    public void run(String... args) throws Exception {
            System.out.printf(IMPORT_SEPARATOR,"SQL Data Import");
            seedService.seedData();

        System.out.println("");
        System.out.printf(IMPORT_SEPARATOR,"Products in Range");
        productService.findProductsInRange(1,1000);

        System.out.printf(IMPORT_SEPARATOR,"Successfully Sold Products");
        userService.getUserBySoldProjects();

        System.out.println("");
        System.out.printf(IMPORT_SEPARATOR,"Categories by Products Count");
        productService.getCategorisFromProductsCount();
        System.out.println("");

        System.out.printf(IMPORT_SEPARATOR,"Users and Products");
        userService.getUsersByCountSoldProjects();
        System.out.println("");

        System.out.println(END_SEPARATOR);
    }
}
