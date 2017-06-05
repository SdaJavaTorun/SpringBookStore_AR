package com.example.bookstore.endpoint;

import com.example.bookstore.model.*;
import com.example.bookstore.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/books")
public class BookStoreEndpoint {

    private final BookService bookService;

    @Autowired
    public BookStoreEndpoint (BookService bookService){
        this.bookService = bookService;
    }
                // sterowanie typem outputu - standardowo wypluwa JSON
    @GetMapping(value = "/hello", produces = MediaType.TEXT_PLAIN_VALUE)
    public String hello(){
        return "<h1>hello-world</h1>"; // przekazuje stringa
    }

    @GetMapping("/book")
    public BookDto getBook(){
        return new BookDto("title", "author");
    }

    @ResponseStatus(HttpStatus.OK)  // zwraca domyslna wartosc 200
    @GetMapping(produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public BookListingDto getBooks() {
        return BookListingDto.toDto(bookService.getListingData());
    }

    @ResponseStatus(HttpStatus.CREATED) // dla status 201
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public void addBook(@RequestBody BookDto bookDto) {
        bookService.addBook(bookDto.fromDto());
    }

    @ResponseStatus(HttpStatus.NO_CONTENT) // dla status 204
    @DeleteMapping(value = "/{id}")
                            // zmienna zdefiniowana w adresie
    public void deleteBook(@PathVariable String id) {
        bookService.deleteBookById(id);
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping(
            value = "/{id}",
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE
            )
    public BookDetailsDto getBookDetails (@PathVariable String id) {
        return BookDetailsDto.toDetailsDto(
                bookService.getBookDetailsById(id));
    }
}
