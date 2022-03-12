package com.example.bookshop_system.Services;

import com.example.bookshop_system.Entities.*;
import com.example.bookshop_system.Repositories.AuthorRepository;
import com.example.bookshop_system.Repositories.BookRepository;
import com.example.bookshop_system.Repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.io.IOException;
import java.math.BigDecimal;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class SeedDatabaseImpl implements SeedDatabase {

    private static final String RESOURCES_PATH = "src/main/resources/files";
    public static final String AUTHORS_FILE_PATH = RESOURCES_PATH + "/authors.txt";
    private static final String CATEGORIES_FILE_PATH = RESOURCES_PATH + "/categories.txt";
    private static final String BOOKS_FILE_PATH = RESOURCES_PATH + "/books.txt";

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;
    private final CategoryRepository categoryRepository;
    private final AuthorService authorService;
    private final CategoryService categoryService;

    @Autowired
    public SeedDatabaseImpl(AuthorRepository authorRepository, BookRepository bookRepository, CategoryRepository categoryRepository, AuthorService authorService, CategoryService categoryService) {
        this.authorRepository = authorRepository;
        this.categoryService = categoryService;
        this.bookRepository = bookRepository;
        this.categoryRepository = categoryRepository;
        this.authorService = authorService;
    }


    @Override
    public void importAuthors() throws IOException {
        Files.readAllLines(Path.of(AUTHORS_FILE_PATH)).stream()
                .filter(a->!a.isBlank())
                .map(a-> a.split(" "))
                .map(b->new Author(b[0],b[1]))
                .forEach(a->{
                            List<Author>authors = authorRepository.findByFirstNameAndLastName(a.getFirst_name(),a.getLast_name());
                            if(authors.isEmpty()){
                                authorRepository.save(a);
                            }
                        }
                );
    }

    @Override
    public void importCategories() throws IOException {

        Files.readAllLines(Path.of(CATEGORIES_FILE_PATH)).stream()
                .filter(a->!a.isBlank())
                .map(Category::new)
                .forEach(a->{
                            List<Category>categories = categoryRepository.findByName(a.getName());
                            if(categories.isEmpty()){
                                categoryRepository.save(a);
                            }
                        }
                );
    }

    @Override
    public void importBooks() throws IOException {
        Files.readAllLines(Path.of(BOOKS_FILE_PATH)).stream()
                .filter(a->!a.isBlank())
                .map(a->a.split(" "))
                .map(b->{
                    EditionTypes editionType = EditionTypes.values()[Integer.parseInt(b[0])];

                    BigDecimal price = new BigDecimal(b[3]);

                    LocalDate date =
                            LocalDate.parse(b[1], DateTimeFormatter.ofPattern("d/M/yyyy"));

                    AgeRestrictions ageRestrictions = AgeRestrictions.values()[Integer.parseInt(b[4])];

                    String title;
                    if(b.length>6) {
                        List<String> titleInput = Arrays.asList(b).subList(5, b.length - 1);
                        title = String.join(" ", titleInput);
                    }else{
                        title = b[5];
                    }

                    Author author = authorService.getRandomAuthor();
                    return new Book(editionType,date,Integer.parseInt(b[2]),price,ageRestrictions,title,author,categoryService.getRandom());
                })
                .forEach(a->{
                    List<Book>books = bookRepository.findByEditionTypesAndReleaseDateAndCopiesAndPriceAndAgeRestrictionAndTitle(a.getEditionTypes(),a.getReleaseDate(),a.getCopies(),a.getPrice(),a.getAgeRestriction(),a.getTitle());
                    if(books.isEmpty()) {
                        bookRepository.save(a);
                    }
                }
                );
    }
}
