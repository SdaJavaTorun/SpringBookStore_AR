package com.example.bookstore.service;

import com.example.bookstore.exception.BookNotFoundException;
import com.example.bookstore.model.Book;
import com.example.bookstore.model.BookDetails;
import com.example.bookstore.model.BookListing;
import com.example.bookstore.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookService {

    private final BookRepository bookRepository;
    private final BookDescriptionClient bookDescriptionClient;

    @Autowired
    public BookService(BookRepository bookRepository,
                       @Qualifier("bookDescriptionLoripsum")
                       //@Qualifier("bookDescriptionLipsum")
                               BookDescriptionClient bookDescriptionClient) {
        this.bookRepository = bookRepository;
        this.bookDescriptionClient = bookDescriptionClient;
    }

    public BookListing getListingData() {
        List<Book> books = bookRepository.findAll();

        return new BookListing(
                books,
                books.size()
        );
    }

    public void addBook(Book book) {
        bookRepository.save(book);
    }

    public void deleteBookById(String id) {
        Optional<Book> book = bookRepository.findById(id);
        if (book.isPresent()) {
            bookRepository.delete(book.get());
        }
        // druga wersja
        //book.ifPresent(bookRepository::delete);
    }

    public BookDetails getBookDetailsById(String id) {
        Optional<Book> book = bookRepository.findById(id);
        /*if (book.isPresent()) {
            return new BookDetails(
                    book.get().getTitle(),
                    book.get().getAuthor(),
                    bookDescriptionClient.getDescription(book.get().getId()));
        }
        else {
            return null;
        }*/
        // zapis z optionalem
        return book.map(bookBack -> new BookDetails(
                bookBack.getTitle(),
                bookBack.getAuthor(),
                bookDescriptionClient.getDescription(bookBack.getId())
        )).orElseThrow(() ->
                new BookNotFoundException("Książka " + id + " nieznaleziona"));
    }
}
