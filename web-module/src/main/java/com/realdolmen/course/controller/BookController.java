package com.realdolmen.course.controller;

import com.realdolmen.course.domain.Book;
import com.realdolmen.course.persistence.BookRepository;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;

@Named
@RequestScoped
public class BookController {

    //dependency injection, gaat via JNDI de BookRepository terugvinden, gebeurt allemaal automatisch
    // vroeger gebruikte men @Resource(lookup="jndi name")
    @Inject
    BookRepository repository;

    public List<Book> getAllBooks() {
        return repository.findAll();
    }

    public void remove(int bookId) {
        repository.remove(bookId);
    }

    public String getTitle() {
        return null;
    }
}
