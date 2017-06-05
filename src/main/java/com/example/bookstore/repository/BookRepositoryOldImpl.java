/*
package com.example.bookstore.repository;

import com.example.bookstore.model.Book;
import com.google.common.collect.Lists;
import org.springframework.stereotype.Repository;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;

@Repository
public class BookRepositoryOldImpl implements BookRepository {
    private List<Book> books = Lists.newArrayList();
    private AtomicLong lastIndex = new AtomicLong(1);

    public List<Book> findAll() {
//        return books; // TODO uncomment BookRepositoryImplTest to check out why it's bad
       // zeby testy nie mogly dodawac owych danych do bazy ksiazek
        return Collections.unmodifiableList(books);
    }

    @Override
    public Optional<Book> findById(String id) {
        return books.stream()
                .filter(book -> id.equals(book.getId()))
                .findFirst();
    }

    @Override
    public void delete(Book book) {
        books.remove(book);
    }

    public void save(Book book) {
        books.add(
                new Book(
                        Long.toString(lastIndex.getAndIncrement()),
                        book.getTitle(),
                        book.getAuthor())
        );
    }
}
*/
