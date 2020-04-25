package com.sviatoslav.library.controller;

import com.sviatoslav.library.entity.Book;
import com.sviatoslav.library.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@RequiredArgsConstructor

@Controller
public class ManageBooksController {

    private final BookService bookService;

    @GetMapping("/admin/manage-books")
    public String getManageBooksPage(Model model) {
        List<Book> books = bookService.findAll();

        model.addAttribute("books", books);
        return "manage-books";
    }

    @PostMapping("/admin/manage-books/delete/{id}")
    public String deleteBook(@PathVariable Long id) {
        bookService.deleteFromBooksAndSavedBooks(id);
        return "redirect:/admin/manage-books";
    }
}
