package com.sviatoslav.library.controller;

import com.sviatoslav.library.entity.Book;
import com.sviatoslav.library.service.BookService;
import com.sviatoslav.library.service.SavedBookService;
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
    private final SavedBookService savedBookService;

    @GetMapping("/book/{id}")
    public String getBookInfoPage(@PathVariable Long id, Model model, Principal principal) {
        String username = principal.getName();
        Book book = bookService.findById(id);

        boolean isAlreadySaved = savedBookService.existsByBookIdAndUsername(book.getId(), username);

        model.addAttribute("book", book);
        model.addAttribute("isSaved", isAlreadySaved);

        return "book";
    }
}
