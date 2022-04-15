package com.example.bookshop_system.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.bookshop_system.Entities.Category;

import java.util.List;


public interface CategoryRepository extends JpaRepository <Category,Integer>{
    public List<Category> findByName(String name);
}
