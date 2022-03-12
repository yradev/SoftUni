package com.example.bookshop_system.Entities;

import javax.persistence.*;
import java.util.Collections;
import java.util.Set;

@Entity
@Table(name = "categories")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int category_id;

    @Column(nullable = false)
    private String name;

    @ManyToMany
            @JoinTable(name = "books_categories",
                    joinColumns = @JoinColumn(name = "category_id",referencedColumnName = "category_id"),
                    inverseJoinColumns = @JoinColumn(name = "book_id",referencedColumnName = "book_id")
            )
    private Set<Book>books;

    public Category() {
    }

    public Category(Set<Book> books) {
        this.books = books;
    }

    public Category(String name) {
        this.name = name;
    }

    public int getCategory_id() {
        return category_id;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Book> getBooks() {
        return Collections.unmodifiableSet(books);
    }

    public void setBooks(Set<Book> books) {
        this.books = books;
    }
}
