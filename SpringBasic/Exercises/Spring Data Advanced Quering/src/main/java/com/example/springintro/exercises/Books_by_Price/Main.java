package com.example.springintro.exercises.Books_by_Price;

import com.example.springintro.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component(value = "Exercise3")
public class Main {

    private static BookService bookService;

    @Autowired
    private Main(BookService bookService) {
        this.bookService = bookService;
    }

    public static void run(){
        bookService.printBooksWithPriceNotBetween(BigDecimal.valueOf(5),BigDecimal.valueOf(40));
    }
}
