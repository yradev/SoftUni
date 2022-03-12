package com.example.bookshop_system.Entities;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Set;

@Entity
@Table(name = "books")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "book_id")
    private int id;
    @Column(nullable = false, length = 50)
    private String title;

    @Column(length = 1000)
    private String description;

    @Column(name = "edition_type",nullable = false)
    private EditionTypes editionTypes;

    @Column(nullable = false)
    private BigDecimal price;

    @Column(nullable = false)
    private int copies;

    @Column(name = "release_date")
    private LocalDate releaseDate;

    @Column(name = "age_restriction",nullable = false)
    private AgeRestrictions ageRestriction;


    @ManyToOne
    @JoinColumn(name = "author_id", referencedColumnName = "author_id")
    private Author author;

    @ManyToMany(targetEntity = Category.class,mappedBy = "books")
    private Set<Category> categories;

    public Book() {
    }

    public Book(EditionTypes editionType, LocalDate releaseDate, int copies, BigDecimal price, AgeRestrictions restrictions, String title,Author author,Set<Category>categories) {
        this.categories = categories;
        this.title = title;
        this.editionTypes = editionType;
        this.price = price;
        this.copies = copies;
        this.releaseDate = releaseDate;
        ageRestriction = restrictions;
        this.author = author;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public EditionTypes getEditionTypes() {
        return editionTypes;
    }

    public void setEditionTypes(EditionTypes editionTypes) {
        this.editionTypes = editionTypes;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public int getCopies() {
        return copies;
    }

    public void setCopies(int copies) {
        this.copies = copies;
    }

    public LocalDate getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(LocalDate releaseDate) {
        this.releaseDate = releaseDate;
    }

    public AgeRestrictions getAgeRestriction() {
        return ageRestriction;
    }

    public void setAgeRestriction(AgeRestrictions ageRestriction) {
        this.ageRestriction = ageRestriction;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public Set<Category> getCategories() {
        return categories;
    }

    public void setCategories(Set<Category> categories) {
        this.categories = categories;
    }
}