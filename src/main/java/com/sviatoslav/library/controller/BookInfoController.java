package com.sviatoslav.library.controller;

import com.sviatoslav.library.entity.Book;
import com.sviatoslav.library.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.security.Principal;

@RequiredArgsConstructor

@Controller
public class BookInfoController {

    private final BookService bookService;

    @GetMapping("/book/{id}")
    public String getBookInfoPage(@PathVariable Long id, Model model) {
        Book book = bookService.findById(id);

        model.addAttribute("book", book);
        return "book";
    }
}
