package com.example.springintro.exercises.Books_Titles_byAge_Restriction;

import com.example.springintro.model.entity.AgeRestriction;
import com.example.springintro.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.Scanner;

import static messages.CoreMessages.INVALID_INPUT;
import static messages.ExerciseMessages.*;

@Component(value = "Exercise1")
public class Main  {
    private static BookService bookService;

    private Main(){
    }

    @Autowired
    private Main(BookService bookService) {
        this.bookService = bookService;
    }

    public static void run(){
        System.out.println(TYPE_AGE_RESTRICTION);
        String input = new Scanner(System.in).nextLine();

        switch (input.toLowerCase()){
            case "minor":
                printer(AgeRestriction.MINOR);
                break;
            case"teen":
                printer(AgeRestriction.TEEN);
                break;
            case"adult":
                printer(AgeRestriction.ADULT);
                break;
            default:
                throw new IllegalStateException(INVALID_INPUT);
        }
    }

    private static void printer(AgeRestriction ageRestriction) {
        bookService.printBooksWithAgeRestriction(ageRestriction);
    }
}
