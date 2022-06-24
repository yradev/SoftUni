package source.service.impl;

import org.springframework.stereotype.Service;
import source.model.entity.Categories;
import source.model.entity.Category;
import source.repository.CategoryRepository;
import source.service.CategoryService;

import javax.validation.constraints.FutureOrPresent;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CategoryServiceDTO implements CategoryService {
    private final CategoryRepository categoryRepository;

    public CategoryServiceDTO(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public void SeedCategories() {
        if (categoryRepository.count() == 0) {
            Arrays.stream(Categories.values())
                    .map(categoryName -> {
                        Category category = new Category();
                        category.setName(categoryName);
                        return category;
                    })
                    .forEach(categoryRepository::save);
        }
    }
}
