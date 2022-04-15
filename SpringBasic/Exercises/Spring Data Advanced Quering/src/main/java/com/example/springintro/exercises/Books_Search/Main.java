package com.example.springintro.exercises.Books_Search;

import com.example.springintro.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Scanner;

import static messages.ExerciseMessages.TYPE_CONTAININGSTRING;

@Component(value = "Exercise 7")
public class Main {
    private static BookService bookService;

    private Main() {}

    @Autowired
    private Main(BookService bookService) {
        this.bookService = bookService;
    }

    public static void run(){
        System.out.println(TYPE_CONTAININGSTRING);
        String value = new Scanner(System.in).nextLine();
        bookService.printBooksThatContainsValue(value);
    }
}
