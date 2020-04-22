package com.sviatoslav.library.controller;

import com.sviatoslav.library.entity.Book;
import com.sviatoslav.library.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.security.Principal;
import java.util.List;

@RequiredArgsConstructor

@Controller
public class BooksOfMineController {

    private final BookService bookService;

    @GetMapping("/my-books")
    public String getMyBooksPage(Principal principal, Model model) {
        String username = principal.getName();
        List<Book> books = bookService.findByUsername(username);

        model.addAttribute("books", books);
        return "my-books";
    }

    @PostMapping("/my-books/delete/{id}")
    public String removeBookFromMyList(@PathVariable Long id) {
        bookService.deleteFromBooksAndSavedBooks(id);
        return "redirect:/my-books";
    }

}
