package com.sviatoslav.library.controller;

import com.sviatoslav.library.controller.mapper.BookMapper;
import com.sviatoslav.library.controller.validator.BookFormValidator;
import com.sviatoslav.library.entity.Book;
import com.sviatoslav.library.entity.form.BookForm;
import com.sviatoslav.library.service.AuthorService;
import com.sviatoslav.library.service.BookService;
import com.sviatoslav.library.service.MediaService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
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

    private final AuthorService authorService;
    private final MediaService mediaService;
    private final BookService bookService;
    private final BookFormValidator bookFormValidator;
    private final BookMapper bookMapper;

    @GetMapping("/add-book")
    public String getAddBookPage(Model model, Principal principal) {
        model.addAttribute("bookForm", new BookForm());

        return "add-book";
    }

    @PostMapping("/add-book")
    public String addBook(@Valid @ModelAttribute BookForm bookForm,
                          BindingResult bindingResult) {

        bookFormValidator.validate(bookForm, bindingResult);
        if (bindingResult.hasErrors()) {
            return "add-book";
        }

        Book book = bookMapper.map(bookForm);

        authorService.save(book.getAuthor());
        mediaService.save(book.getHardcoverFile());
        mediaService.save(book.getBookFile());
        bookService.save(book);

        return "redirect:/books";
    }

}
