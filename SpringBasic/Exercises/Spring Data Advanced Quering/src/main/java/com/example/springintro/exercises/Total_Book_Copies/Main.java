package com.example.springintro.exercises.Total_Book_Copies;

import com.example.springintro.service.AuthorService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component(value = "Exercise10")
public class Main {
    private static AuthorService authorService;

    @Autowired
    private Main(AuthorService authorService) {
        this.authorService = authorService;
    }

    public static void run() {
        authorService.printAuthorAndSumCopies();
    }
}
