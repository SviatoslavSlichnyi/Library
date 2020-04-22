package com.sviatoslav.library.controller;

import com.sviatoslav.library.entity.Book;
import com.sviatoslav.library.entity.SavedBooks;
import com.sviatoslav.library.entity.User;
import com.sviatoslav.library.service.BookService;
import com.sviatoslav.library.service.SavedBooksService;
import com.sviatoslav.library.service.UserService;
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
public class BooksSavedController {

    private final SavedBooksService savedBooksService;
    private final BookService bookService;
    private final UserService userService;

    @GetMapping("/saved-books")
    public String getSavedBooksPage(Principal principal, Model model) {
        String username = principal.getName();
        List<Book> books = savedBooksService.findBooksByUsername(username);

        model.addAttribute("books", books);
        return "saved-books";
    }

    @PostMapping("/saved-books/save/{id}")
    public String saveBook(@PathVariable Long id, Principal principal) {
        Book book = bookService.findById(id);

        String username = principal.getName();
        User user = userService.findByUsername(username);

        SavedBooks savedBooks = SavedBooks.builder()
                .book(book)
                .user(user)
                .build();
        savedBooksService.save(savedBooks);

        return "redirect:/book/" + id;
    }

    @PostMapping("/saved-books/remove/{id}")
    public String removeBookFromSaved(@PathVariable Long id, Principal principal) {
        String username = principal.getName();
        SavedBooks savedBook = savedBooksService.findByBookIdAndUserUsername(id, username);

        savedBooksService.delete(savedBook);

        return "redirect:/saved-books";
    }
}
