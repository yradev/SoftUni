package com.example.springintro.exercises.Reduced_Book;

import com.example.springintro.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Scanner;

import static messages.ExerciseMessages.TYPE_TITLE;

@Component(value = "Exercise11")
public class Main {

    private static BookService bookService;
    private Main() {
    }

    @Autowired
    private Main(BookService bookService) {
        this.bookService = bookService;
    }

    public static void run() {
        System.out.println(TYPE_TITLE);
        String title = new Scanner(System.in).nextLine();
        bookService.printBookWithTitle(title);
    }
}
