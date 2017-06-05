package com.example.bookstore.repository;

import com.example.bookstore.model.Book;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.junit.Assert.*;

public class BookRepositoryImplTest {
    BookRepository bookRepository;

    @Before
    public void setUp() {
        bookRepository = new BookRepositoryImpl();
    }

//    @Test
//    public void shouldNotMutateData() throws Exception {
//        bookRepository.save(new Book("Title1", "Author1"));
//        bookRepository.save(new Book("Title2", "Author3"));
//
//        List<Book> books = bookRepository.findAll();
//
//        assertEquals(2, books.size());
//
//        books.add(new Book("Title3", "Author3"));
//
//        assertEquals(2, bookRepository.findAll().size());
//    }

}