package com.example.springintro.repository;

import com.example.springintro.model.entity.AgeRestriction;
import com.example.springintro.model.entity.Book;
import com.example.springintro.model.entity.EditionType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
    List<Book> findByAgeRestriction(AgeRestriction AgeRestriction);
    List<Book> findByEditionTypeAndCopiesLessThan(EditionType editionType,int number);

    @Query(
            "SELECT b from Book b WHERE b.price NOT BETWEEN :lessThan AND :greaterThan"
    )
    List<Book> findBooksNotBetween(BigDecimal lessThan, BigDecimal greaterThan );

    @Query(
            "SELECT b FROM Book b WHERE b.releaseDate NOT BETWEEN :start_date AND :end_date"
    )
    List<Book>findBookByReleaseDateNot(LocalDate start_date,LocalDate end_date);

    List<Book>findBookByReleaseDateBefore(LocalDate date);

    @Query(
            "SELECT a FROM Book a WHERE locate(upper(:text),upper(a.title))>0"
    )
    List<Book>findBookByTitleContains(String text);


    List<Book>findBookByAuthor_LastNameStartingWith(String text);
    @Query(
            "SELECT a FROM Book a WHERE length(a.title) > :size"
    )
    List<Book>findBookByTitleLength(int size);


    List<Book>findBookByTitle(String title);
}
