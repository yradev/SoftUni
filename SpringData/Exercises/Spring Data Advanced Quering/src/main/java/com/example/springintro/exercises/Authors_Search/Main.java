package com.example.springintro.exercises.Authors_Search;

import com.example.springintro.service.AuthorService;
import com.example.springintro.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Scanner;

import static messages.ExerciseMessages.TYPE_ENDTEXT;

@Component (value = "Exercise6")
public class Main {
    private static AuthorService authorService;

    @Autowired
    private Main(AuthorService authorService) {
        this.authorService = authorService;
    }

    public static void run(){
        System.out.println(TYPE_ENDTEXT);
        String input = new Scanner(System.in).nextLine();
        authorService.printAuthorWithFirstNameEndingWith(input);
    }
}
