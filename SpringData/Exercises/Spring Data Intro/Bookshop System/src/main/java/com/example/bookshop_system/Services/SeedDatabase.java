package com.example.bookshop_system.Services;

import org.springframework.stereotype.Service;

import java.io.IOException;

public interface SeedDatabase {
    void importAuthors() throws IOException;
    void importCategories() throws IOException;
    void importBooks() throws IOException;

    default void importAll() throws IOException {
        importAuthors();
        importCategories();
        importBooks();
    }
}
