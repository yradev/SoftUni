package com.example.springintro.service;

import com.example.springintro.model.entity.AgeRestriction;
import com.example.springintro.model.entity.EditionType;

import java.io.IOException;
import java.math.BigDecimal;
import java.time.LocalDate;

public interface BookService {
    void seedBooks() throws IOException;
    void printBooksWithAgeRestriction(AgeRestriction ageRestriction);
    void printBooksWithEditonTypeAndCopiesLessThan(EditionType editionType, int number);
    void printBooksWithPriceNotBetween (BigDecimal biggerThan, BigDecimal lowerThan);
    void printBooksThatAreNotInYear(int Year);
    void printBooksRealasedBeforeDate(LocalDate date);
    void printBooksThatContainsValue(String value);
    void printBooksWithAuthorsLastNameStartsWith(String value);
    int getBooksSize(int value);
    void printBookWithTitle(String title);
}
