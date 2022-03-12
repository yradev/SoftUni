package com.example.bookshop_system.Services;

import com.example.bookshop_system.Entities.Category;
import com.example.bookshop_system.Repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

@Service
public class CategoryServiceImpl implements CategoryService{

    private CategoryRepository categoryRepository;

    @Autowired
    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public Set<Category> getRandom() {
        int size =  new Random().nextInt((int)categoryRepository.count())+1;

        Set<Category> categories = new HashSet<>();

        for(int i=1;i<=size;i++){
            Category category = categoryRepository.findById(i).get();
            categories.add(category);
        }

        return categories;
    }
}
