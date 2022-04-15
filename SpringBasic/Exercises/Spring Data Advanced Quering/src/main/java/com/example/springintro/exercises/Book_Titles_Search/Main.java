package com.example.springintro.exercises.Book_Titles_Search;

import com.example.springintro.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Scanner;

import static messages.ExerciseMessages.TYPE_START_TEXT_LASTNAME;

@Component(value = "exercise8")
public class Main {
    private static BookService bookService;

    @Autowired
    private Main(BookService bookService) {
        this.bookService = bookService;
    }

    public static void run(){
        System.out.println(TYPE_START_TEXT_LASTNAME);
        String value = new Scanner(System.in).nextLine();
        bookService.printBooksWithAuthorsLastNameStartsWith(value);
    }

}
