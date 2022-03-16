package com.example.springintro.exercises.Not_Released_Books;

import com.example.springintro.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Scanner;

import static messages.ExerciseMessages.*;

@Component(value = "Exercise4")
public class Main {
    private static BookService bookService;

    @Autowired
    private Main(BookService bookService) {
        this.bookService = bookService;
    }

    public static void run(){
        System.out.println(TYPE_YEAR);

        String input = new Scanner(System.in).nextLine();

        bookService.printBooksThatAreNotInYear(Integer.parseInt(input));
    }
}
