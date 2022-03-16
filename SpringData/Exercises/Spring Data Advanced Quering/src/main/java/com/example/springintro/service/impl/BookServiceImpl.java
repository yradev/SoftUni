package com.example.springintro.service.impl;

import com.example.springintro.model.entity.*;
import com.example.springintro.repository.BookRepository;
import com.example.springintro.service.AuthorService;
import com.example.springintro.service.BookService;
import com.example.springintro.service.CategoryService;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.math.BigDecimal;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class BookServiceImpl implements BookService {

    private static final String BOOKS_FILE_PATH = "src/main/resources/files/books.txt";

    private final BookRepository bookRepository;
    private final AuthorService authorService;
    private final CategoryService categoryService;

    public BookServiceImpl(BookRepository bookRepository, AuthorService authorService, CategoryService categoryService) {
        this.bookRepository = bookRepository;
        this.authorService = authorService;
        this.categoryService = categoryService;
    }

    @Override
    public void seedBooks() throws IOException {
        if (bookRepository.count() > 0) {
            return;
        }

        Files
                .readAllLines(Path.of(BOOKS_FILE_PATH))
                .forEach(row -> {
                    String[] bookInfo = row.split("\\s+");

                    Book book = createBookFromInfo(bookInfo);

                    bookRepository.save(book);
                });
    }

    @Override
    public void printBooksWithAgeRestriction(AgeRestriction ageRestriction) {
        bookRepository.findByAgeRestriction(ageRestriction).forEach(a-> System.out.println(a.getTitle()));
    }

    @Override
    public void printBooksWithEditonTypeAndCopiesLessThan(EditionType editionType, int number) {
        bookRepository.findByEditionTypeAndCopiesLessThan(editionType,number).forEach(a-> System.out.println(a.getTitle()));
    }

    @Override
    public void printBooksWithPriceNotBetween(BigDecimal biggerThan, BigDecimal lowerThan) {
        bookRepository.findBooksNotBetween(lowerThan,biggerThan).forEach(a-> System.out.printf("%s - $%.2f\n",a.getTitle(),a.getPrice()));
    }

    @Override
    public void printBooksThatAreNotInYear(int year) {
       bookRepository.findBookByReleaseDateNot(LocalDate.of(year,1,1),LocalDate.of(year,12,31)).forEach(a-> System.out.println(a.getTitle()));

    }

    @Override
    public void printBooksRealasedBeforeDate(LocalDate date) {
        bookRepository.findBookByReleaseDateBefore(date).forEach(a-> System.out.printf("%s %s %.2f\n",a.getTitle(),a.getEditionType().name(),a.getPrice()));
    }

    @Override
    public int getBooksSize(int value) {
       return bookRepository.findBookByTitleLength(value).size();
    }

    @Override
    public void printBookWithTitle(String title) {
        bookRepository.findBookByTitle(title).forEach(a->System.out.printf("%s %s %s %s",a.getTitle(),a.getEditionType().name(),a.getAgeRestriction(),a.getPrice()));
    }

    @Override
    public void printBooksWithAuthorsLastNameStartsWith(String value) {
        bookRepository.findBookByAuthor_LastNameStartingWith(value).forEach(a-> System.out.printf("%s (%s %s)\n",a.getTitle(),a.getAuthor().getFirstName(),a.getAuthor().getLastName()));
    }

    @Override
    public void printBooksThatContainsValue(String value) {
        bookRepository.findBookByTitleContains(value).forEach(a-> System.out.println(a.getTitle()));
    }

    private Book createBookFromInfo(String[] bookInfo) {
        EditionType editionType = EditionType.values()[Integer.parseInt(bookInfo[0])];
        LocalDate releaseDate = LocalDate
                .parse(bookInfo[1], DateTimeFormatter.ofPattern("d/M/yyyy"));
        Integer copies = Integer.parseInt(bookInfo[2]);
        BigDecimal price = new BigDecimal(bookInfo[3]);
        AgeRestriction ageRestriction = AgeRestriction
                .values()[Integer.parseInt(bookInfo[4])];
        String title = Arrays.stream(bookInfo)
                .skip(5)
                .collect(Collectors.joining(" "));

        Author author = authorService.getRandomAuthor();
        Set<Category> categories = categoryService
                .getRandomCategories();

        return new Book(editionType, releaseDate, copies, price, ageRestriction, title, author, categories);

    }
}
