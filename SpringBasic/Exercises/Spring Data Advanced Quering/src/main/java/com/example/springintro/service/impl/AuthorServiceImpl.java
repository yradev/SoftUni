package com.example.springintro.service.impl;

import com.example.springintro.model.entity.Author;
import com.example.springintro.model.entity.Book;
import com.example.springintro.repository.AuthorRepository;
import com.example.springintro.service.AuthorService;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;

@Service
public class AuthorServiceImpl implements AuthorService {

    private static final String AUTHORS_FILE_PATH = "src/main/resources/files/authors.txt";

    private final AuthorRepository authorRepository;

    public AuthorServiceImpl(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    @Override
    public void seedAuthors() throws IOException {
        if (authorRepository.count() > 0) {
            return;
        }

        Files
                .readAllLines(Path.of(AUTHORS_FILE_PATH))
                .forEach(row -> {
                    String[] fullName = row.split("\\s+");
                    Author author = new Author(fullName[0], fullName[1]);

                    authorRepository.save(author);
                });
    }

    @Override
    public Author getRandomAuthor() {
        long randomId = ThreadLocalRandom
                .current().nextLong(1,
                        authorRepository.count() + 1);

        return authorRepository
                .findById(randomId)
                .orElse(null);
    }

    @Override
    public void printAuthorWithFirstNameEndingWith(String input) {
        authorRepository.findAuthorByFirstNameEndingWith(input).forEach(a-> System.out.printf("%s %s\n",a.getFirstName(),a.getLastName()));
    }

    @Override
    public void printAuthorAndSumCopies() {
        authorRepository.findAll().stream()
                .sorted((a,b)->{
                    int result;
                    int sum1 = a.getBooks().stream()
                            .mapToInt(Book::getCopies)
                            .sum();
                    int sum2 = b.getBooks().stream()
                            .mapToInt(Book::getCopies)
                            .sum();

                    result = Integer.compare(sum2,sum1);
                    return result;
                })
                .forEach(a->
        {
            int sum = a.getBooks().stream()
                    .mapToInt(Book::getCopies)
                            .sum();
            System.out.printf("%s %s - %s\n", a.getFirstName(), a.getLastName(), sum);
        });
    }

}
