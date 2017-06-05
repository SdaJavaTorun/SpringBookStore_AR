package com.example.bookstore;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BookstoreApplication implements CommandLineRunner {

//	private final BookService bookService;

	@Value("${mymessage}")
	private String message;

//	@Autowired
//	public BookstoreApplication(BookService bookService) {
//		this.bookService = bookService;
//	}

	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}

	@Override
	public void run(String... strings) throws Exception {
//		bookService.addBook(new Book("Spring", "Autor 1"));
//		bookService.addBook(new Book("Mongo", "Autor 2"));
//
//		System.out.println(bookService.getListingData());
	}
}
