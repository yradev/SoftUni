package com.example.bookshop_system.Repositories;

import com.example.bookshop_system.Entities.Author;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface AuthorRepository extends JpaRepository<Author, Integer> {
    List<Author> findByFirstNameAndLastName(String first_name,String last_name);
}
