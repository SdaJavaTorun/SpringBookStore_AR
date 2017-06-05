package com.example.bookstore.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;

public class BookDto {
    private String id;
    @JsonProperty("title")  // mapowanie nazwy w jsonie zeby zwracal title
    private String name;
    private String author;

    public BookDto() {
    }

    public BookDto(String name, String author) {
        this(null, name, author);
    }

    public BookDto(String id, String name, String author) {
        this.id = id;
        this.name = name;
        this.author = author;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Book fromDto() {
        return new Book(name, author);
    }

    public static BookDto toDto(Book book) {
        return new BookDto(book.getId(), book.getTitle(), book.getAuthor());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BookDto bookDto = (BookDto) o;
        return Objects.equals(name, bookDto.name) &&
                Objects.equals(author, bookDto.author);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, author);
    }
}
