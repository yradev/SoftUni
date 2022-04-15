package com.example.bookshop_system.Repositories;

import com.example.bookshop_system.Entities.AgeRestrictions;
import com.example.bookshop_system.Entities.Book;
import com.example.bookshop_system.Entities.EditionTypes;
import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.Year;
import java.util.List;

public interface BookRepository extends JpaRepository<Book,Integer> {
    public List<Book>findByEditionTypesAndReleaseDateAndCopiesAndPriceAndAgeRestrictionAndTitle(EditionTypes editionType, LocalDate releaseDate, int copies, BigDecimal price, AgeRestrictions restrictions, String title);
    public List<Book> findByReleaseDateAfter(LocalDate date);
    public List<Book> findDistinctByReleaseDateBefore(LocalDate date);
}
