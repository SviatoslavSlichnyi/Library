package com.sviatoslav.library.controller;

import com.sviatoslav.library.entity.Book;
import com.sviatoslav.library.entity.Role;
import com.sviatoslav.library.entity.User;
import com.sviatoslav.library.entity.enumeration.UserRole;
import com.sviatoslav.library.service.BookService;
import com.sviatoslav.library.service.SavedBooksService;
import com.sviatoslav.library.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.security.Principal;
import java.util.Set;

@RequiredArgsConstructor

@Controller
public class BookInfoController {

    private final BookService bookService;
    private final SavedBooksService savedBooksService;
    private final UserService userService;

    @GetMapping("/book/{id}")
    public String getBookInfoPage(@PathVariable Long id, Model model, Principal principal) {
        String username = principal.getName();

        Book book = bookService.findById(id);
        User bookUser = book.getUser();
        User user = userService.findByUsername(username);
        Set<Role> roles = user.getRoles();

        boolean hasEditAccess = bookUser.getUsername().equals(username)
                || roles.contains(new Role(UserRole.ROLE_ADMIN));
        boolean isUser = roles.contains(new Role(UserRole.ROLE_USER));
        boolean isAlreadySaved = savedBooksService.existsByBookIdAndUserId(book.getId(), user.getId());

        model.addAttribute("book", book);
        model.addAttribute("username", bookUser.getUsername());
        model.addAttribute("hasEditAccess", hasEditAccess);
        model.addAttribute("isUser", isUser);
        model.addAttribute("isSaved", isAlreadySaved);

        return "book";
    }
}
