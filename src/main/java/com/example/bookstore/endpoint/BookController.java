package com.example.bookstore.endpoint;

import com.example.bookstore.model.Book;
import com.example.bookstore.model.BookDto;
import com.example.bookstore.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Date;
import java.util.Map;


@Controller
@RequestMapping("/books")
public class BookController {
    private final BookService bookService;

    @Autowired
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("/hello/{text}")
    public String hello(@PathVariable("text") String text,
                        Map<String, Object> model) {
        model.put("text", text);
        return "hello";
    }

    @GetMapping()
    public String listing(Map<String, Object> model) {
        model.put("time", new Date());
        model.put("listing", bookService.getListingData());
        return "book-listing";
    }

    @PostMapping()
    public String addBook(@ModelAttribute BookDto bookDto,
                          RedirectAttributes redirectAttributes) {
        bookService.addBook(bookDto.fromDto());
        redirectAttributes.addFlashAttribute("result", "Książka została dodana.");
        return "redirect:/books";
    }

    @GetMapping("/delete/{id}")
    public String listing(@PathVariable String id,
                          RedirectAttributes redirectAttributes) {
        bookService.deleteBookById(id);
        redirectAttributes.addFlashAttribute("result", "Książka o id " + id + " została usunięta.");
        return "redirect:/books";
    }
}
