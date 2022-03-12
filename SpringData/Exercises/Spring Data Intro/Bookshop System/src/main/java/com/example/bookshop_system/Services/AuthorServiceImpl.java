package com.example.bookshop_system.Services;

import com.example.bookshop_system.Entities.Author;
import com.example.bookshop_system.Repositories.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;

@Service
public class AuthorServiceImpl implements AuthorService {

    private AuthorRepository authorRepository;

    @Autowired
    public AuthorServiceImpl(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    @Override
    public Author getRandomAuthor() {
        int index = new Random().nextInt((int)authorRepository.count())+1;

       return authorRepository.findById(index).get();
    }
}
