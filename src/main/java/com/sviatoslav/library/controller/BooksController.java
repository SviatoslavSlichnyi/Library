package com.sviatoslav.library.controller;

import com.sviatoslav.library.entity.Book;
import com.sviatoslav.library.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@RequiredArgsConstructor

@Controller
public class BooksController {

    private final BookService bookService;

    @GetMapping("/books")
    public String getBooksPage(Model model) {
        List<Book> books = bookService.findAll();
        model.addAttribute("books", books);

        return "books";
    }

}
