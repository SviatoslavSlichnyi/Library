package com.sviatoslav.library.controller;

import com.sviatoslav.library.controller.mapper.BookMapper;
import com.sviatoslav.library.controller.validator.BookFormValidator;
import com.sviatoslav.library.entity.Book;
import com.sviatoslav.library.entity.User;
import com.sviatoslav.library.entity.form.BookForm;
import com.sviatoslav.library.service.BookService;
import com.sviatoslav.library.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import java.security.Principal;

@RequiredArgsConstructor

@Controller
public class AddBookController {

    private final UserService userService;
    private final BookService bookService;
    private final BookFormValidator bookFormValidator;
    private final BookMapper bookMapper;

    @GetMapping("/add-book")
    public String getAddBookPage(Model model) {
        model.addAttribute("bookForm", new BookForm());
        return "add-book";
    }

    @PostMapping("/add-book")
    public String addBook(@Valid @ModelAttribute BookForm bookForm,
                          BindingResult bindingResult,
                          Principal principal) {
        bookFormValidator.validate(bookForm, bindingResult);
        if (bindingResult.hasErrors()) {
            return "add-book";
        }

        String username = principal.getName();
        User user = userService.findByUsername(username);

        Book book = bookMapper.map(bookForm, user);
        bookService.saveBookAndFields(book);

        return "redirect:/my-books";
    }

}
