package com.example.bookstore.service;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@Qualifier("bookDescriptionDummy")
public class BookDescriptionDummy implements BookDescriptionClient {

    private BookService bookService;

    @Override
    public String getDescription(String bookId) {
        return "book description";
    }
}
