package com.example.bookshop_system.Entities;

import javax.persistence.*;
import javax.persistence.Table;
import java.util.Collections;
import java.util.Set;

@Entity
@Table(name = "authors")
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "author_id")
    private int id;

    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name",nullable = false)
    private String lastName;

    @OneToMany(targetEntity = Book.class,mappedBy = "author")
    private Set<Book>books;


    public Author() {
    }

    public Author(String first_name, String last_name) {
        this.firstName = first_name;
        this.lastName = last_name;
    }

    public int getAuthor_id() {
        return id;
    }

    public String getFirst_name() {
        return firstName;
    }

    public void setFirst_name(String first_name) {
        this.firstName = first_name;
    }

    public String getLast_name() {
        return lastName;
    }

    public void setLast_name(String last_name) {
        this.lastName = last_name;
    }

    public Set<Book> getBooks() {
        return Collections.unmodifiableSet(books);
    }
}
