package com.example.bookstore.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

// ignoruje pole ktore nie ma na liscie
@JsonIgnoreProperties(ignoreUnknown = true)
public class BookListingDto {
    private List<Book> books;
    private int count;

    public BookListingDto(List<Book> books, int count) {
        this.books = books;
        this.count = count;
    }

    public List<Book> getBooks() {
        return books;
    }

    public int getCount() {
        return count;
    }

    public static BookListingDto toDto (BookListing bookListing) {
        return new BookListingDto(
                bookListing.getBooks(),
                bookListing.getCount());
    }
}
