package source.service.IMPL;

import org.springframework.stereotype.Service;
import source.model.entity.Categories;
import source.model.entity.Category;
import source.repository.CategoryRepository;
import source.service.CategoryService;

import java.util.Arrays;
import java.util.Locale;

@Service
public class CategoryServiceIMPL implements CategoryService {

    private final CategoryRepository categoryRepository;

    public CategoryServiceIMPL(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public void seedCategories() {
        if (categoryRepository.count() == 0) {
            Arrays.stream(Categories.values()).map(category -> {
                Category tempCategory = new Category();

                tempCategory.setName(String.format("%s%s",category.name().charAt(0),category.name().substring(1).toLowerCase(Locale.ROOT)));
                tempCategory.setNeededTime(category.neededTime);

                return tempCategory;
            }).forEach(categoryRepository::save);
        }
    }
}
