package source.init;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import source.service.CategoryService;

@Component
public class Seeder implements CommandLineRunner {
    private final CategoryService categoryService;

    public Seeder(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @Override
    public void run(String... args) throws Exception {
        categoryService.seedCategories();
    }

}
