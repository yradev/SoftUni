package source.service.impl;

import org.springframework.stereotype.Service;
import source.model.entity.Categories;
import source.model.entity.Category;
import source.repository.CategoryRepository;
import source.service.CategoryService;

import java.util.Arrays;

@Service
public class CategoryServiceIMPL implements CategoryService {

    private final CategoryRepository categoryRepository;

    public CategoryServiceIMPL(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public void seedCategories() {
        if (categoryRepository.count() == 0) {
            Arrays.stream(Categories.values())
                    .map(category -> new Category(category.name()))
                    .forEach(categoryRepository::save);
        }
    }
}
