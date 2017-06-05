package com.example.bookstore.repository;

import com.example.bookstore.model.Book;

import java.util.List;
import java.util.Optional;

public interface BookRepository {
    List<Book> findAll();

    Optional<Book> findById(String id);

    void delete(Book book);

    void save(Book book);
}
