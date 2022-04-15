package com.example.springintro.exercises.Count_Books;

import com.example.springintro.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Scanner;

import static messages.ExerciseMessages.TYPE_TITLELENGTH;

@Component(value = "exercise9")
public class Main {
    private static BookService bookService;

    @Autowired
    private Main(BookService bookService) {
        this.bookService = bookService;
    }

    public static void run(){
        System.out.println(TYPE_TITLELENGTH);
        String input = new Scanner(System.in).nextLine();

        System.out.println(bookService.getBooksSize(Integer.parseInt(input)));
    }
}
