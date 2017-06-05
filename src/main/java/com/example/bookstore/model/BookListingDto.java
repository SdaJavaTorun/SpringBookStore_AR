package com.example.bookstore.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;
import java.util.stream.Collectors;

// ignoruje pole ktore nie ma na liscie
@JsonIgnoreProperties(ignoreUnknown = true)
public class BookListingDto {
    private List<BookDto> books;
    private int count;

    public BookListingDto(List<BookDto> books, int count) {
        this.books = books;
        this.count = count;
    }

    public List<BookDto> getBooks() {
        return books;
    }

    public int getCount() {
        return count;
    }

    public static BookListingDto toDto (BookListing bookListing) {
        return new BookListingDto(
                bookListing.getBooks()
                        .stream()
                        .map(book -> BookDto.toDto(book))
                        //.map(BookDto::toDto)
                        .collect(Collectors.toList()),
                bookListing.getCount());
    }
}
