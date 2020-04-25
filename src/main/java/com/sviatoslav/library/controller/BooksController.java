package com.sviatoslav.library.controller;

import com.sviatoslav.library.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@RequiredArgsConstructor

@Controller
public class BooksController {

    private final BookService bookService;

    @GetMapping("/books")
    public String getBooksPage(Model model) {
        model.addAttribute("books", bookService.findAll());
        return "books";
    }

}
