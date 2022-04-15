package com.example.springintro.exercises.Books_Released_Before_Date;

import com.example.springintro.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

import static messages.ExerciseMessages.TYPE_DATE;

@Component(value = "Exercise5")
public class Main {

    private static LocalDate date;
    private static BookService bookService;

    @Autowired
    private Main(BookService bookService) {
        this.bookService = bookService;
    }

    public static void run(){

        System.out.println(TYPE_DATE);
        String input = new Scanner(System.in).nextLine();

        date = LocalDate.parse(input,DateTimeFormatter.ofPattern("dd-MM-yyyy"));

        bookService.printBooksRealasedBeforeDate(date);
    }
}
