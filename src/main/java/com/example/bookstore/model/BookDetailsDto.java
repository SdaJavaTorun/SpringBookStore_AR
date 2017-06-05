package com.example.bookstore.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class BookDetailsDto {
    private final String title;
    private final String author;
    private final String description;

    public BookDetailsDto(String title, String author, String description) {
        this.title = title;
        this.author = author;
        this.description = description;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public String toString() {
        return "BookDetailsDto{" +
                "title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", description='" + description + '\'' +
                '}';
    }

    public static BookDetailsDto toDetailsDto (BookDetails bookDeteils) {
        return new BookDetailsDto(
                bookDeteils.getTitle(),
                bookDeteils.getAuthor(),
                bookDeteils.getDescription());
    }
}

