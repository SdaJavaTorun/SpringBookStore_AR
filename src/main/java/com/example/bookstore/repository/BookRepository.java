package com.example.bookstore.repository;

import com.example.bookstore.model.Book;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BookRepository extends MongoRepository<Book, String>,
    BookRepositoryCustom {
    //List<Book> findAll();
    Optional<Book> findById(String id);

    @Query("{title : ?0}")
    Optional<Book> findUsingCustomQueryTralala(String title);


    //void delete(Book book);
    //Book save(Book book);
}
