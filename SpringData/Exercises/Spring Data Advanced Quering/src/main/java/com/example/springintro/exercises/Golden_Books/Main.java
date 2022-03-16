package com.example.springintro.exercises.Golden_Books;

import com.example.springintro.model.entity.EditionType;
import com.example.springintro.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component(value = "Exercise2")
public class Main {

    private static BookService bookService;

    private Main(){}

    @Autowired
    private Main(BookService bookService) {
        this.bookService = bookService;
    }

    public static void run(){
        bookService.printBooksWithEditonTypeAndCopiesLessThan(EditionType.GOLD,5000);
    }
}
