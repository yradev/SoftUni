package com.example.bookshop_system;

import com.example.bookshop_system.Entities.Author;
import com.example.bookshop_system.Entities.Book;
import com.example.bookshop_system.Repositories.AuthorRepository;
import com.example.bookshop_system.Repositories.BookRepository;
import com.example.bookshop_system.Services.SeedDatabase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.io.IOException;
import java.time.LocalDate;
import java.util.Comparator;
import java.util.List;

@Component
public class ConsoleRunner implements CommandLineRunner {

    private SeedDatabase seedDatabase;
    private AuthorRepository authorRepository;
    private BookRepository bookRepository;

    @Autowired
    public ConsoleRunner(SeedDatabase seedDatabase, AuthorRepository authorRepository, BookRepository bookRepository) throws IOException {
        this.bookRepository = bookRepository;
        this.seedDatabase = seedDatabase;
        this.authorRepository = authorRepository;
        seedDatabase.importAll();
    }



    @Override
    @Transactional
    public void run(String... args) throws Exception {
        getYearThan200();
        System.out.println("--------------------------------------------");
        getAuthorsBefore1990();
        System.out.println("--------------------------------------------");
        getAuthorsOrderedByBookCount();
        System.out.println("--------------------------------------------");
        getGeorgeBooks();
    }

    private void getGeorgeBooks() {
        Author author = authorRepository.findByFirstNameAndLastName("George","Powell").get(0);
        author.getBooks().stream()
                .sorted((a,b)->{
                    int result;

                    result = b.getReleaseDate().compareTo(a.getReleaseDate());
                    if(result==0){
                        result = a.getTitle().compareTo(b.getTitle());
                    }
                    return result;
                })
                .forEach(a-> System.out.printf("%s %s %s\n",a.getTitle(),a.getReleaseDate(),a.getCopies()));
    }

    private void getAuthorsBefore1990() {
        List<Book>books = bookRepository.findDistinctByReleaseDateBefore(LocalDate.of(1990,1,1));
        books.forEach(a-> System.out.printf("%s %s\n",a.getAuthor().getFirst_name(), a.getAuthor().getLast_name()));
    }

    private void getYearThan200() {
        bookRepository.findByReleaseDateAfter(LocalDate.of(2000, 12, 31)).forEach(a-> System.out.println(a.getTitle()));
    }

    private void getAuthorsOrderedByBookCount() {
        List<Author> authors = this.authorRepository.findAll();

        authors
                .stream()
                .sorted((l, r) -> r.getBooks().size() - l.getBooks().size())
                .forEach(author ->
                        System.out.printf("%s %s -> %d%n",
                                author.getFirst_name(),
                                author.getLast_name(),
                                author.getBooks().size()));
    }
}
