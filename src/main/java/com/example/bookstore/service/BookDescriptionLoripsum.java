package com.example.bookstore.service;

import com.example.bookstore.model.BookDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestOperations;

@Component
@Qualifier("bookDescriptionLoripsum")
public class BookDescriptionLoripsum implements BookDescriptionClient {

    private final RestOperations restOperations;

    @Autowired
    public BookDescriptionLoripsum(RestOperations restOperations) {
        this.restOperations = restOperations;
    }

    @Override
    public String getDescription(String bookId) {
        // wejscie w mikrouslugi
        restOperations.postForEntity("http://localhost:8090/api/books",
                new BookDto("titee", "asd"), BookDto.class);
        return restOperations.getForEntity(
                "http://loripsum.net/api/plaintext",
                String.class)
                .getBody();
    }

}
