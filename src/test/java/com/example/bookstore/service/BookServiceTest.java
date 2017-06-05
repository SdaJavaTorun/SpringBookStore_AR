package com.example.bookstore.service;

import com.example.bookstore.model.Book;
import com.example.bookstore.model.BookListing;
import com.example.bookstore.repository.BookRepository;
import com.example.bookstore.repository.BookRepositoryImpl;
import org.assertj.core.util.Lists;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class BookServiceTest {

    BookRepository bookRepository;
    BookService bookService;
    BookDescriptionClient descriptionClient;

    @Before
    public void setUp() {
        bookRepository = mock(BookRepositoryImpl.class);
        descriptionClient = mock(BookDescriptionClient.class);
        bookService = new BookService(bookRepository, descriptionClient);
        when(bookRepository.findAll()).thenReturn(
                Lists.newArrayList(
                        new Book("1","title1", "autor1"),
                        new Book("2","title2", "autor2")
                )
        );
    }

    @Test
    public void getListingData() throws Exception {
        // given

        // when
        BookListing bookListing = bookService.getListingData();

        // then
        assertEquals(
                new BookListing(
                        Lists.newArrayList(
                                new Book("1","title1", "autor1"),
                                new Book("2", "title2", "autor2")
                        ),
                        2
                ),
                bookListing);
        verify(bookRepository).findAll();
    }

}