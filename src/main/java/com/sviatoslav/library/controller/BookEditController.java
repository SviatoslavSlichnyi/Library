package com.sviatoslav.library.controller;

import com.sviatoslav.library.controller.mapper.BookMapper;
import com.sviatoslav.library.controller.validator.BookFormValidator;
import com.sviatoslav.library.entity.Book;
import com.sviatoslav.library.entity.MediaMultipartFile;
import com.sviatoslav.library.entity.form.BookForm;
import com.sviatoslav.library.service.BookService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@RequiredArgsConstructor

@Controller
@Slf4j
public class BookEditController {

    private final BookFormValidator bookFormValidator;
    private final BookService bookService;
    private final BookMapper bookMapper;

    @GetMapping("/edit-book/{id}")
    public String getEditBookPage(@PathVariable Long id, Model model) {
        Book book = bookService.findById(id);
        BookForm bookForm = bookMapper.map(book);

        model.addAttribute("bookForm", bookForm);
        return "edit-book";
    }

    @PostMapping("/edit-book/{id}")
    public String updateBook(@Valid @ModelAttribute BookForm bookForm,
                             BindingResult bindingResult,
                             @PathVariable Long id) {
        log.debug("POST: edit book: " + bookForm);

        Book book = bookService.findById(id);
        if (bookForm.getHardcoverFile().isEmpty()) {
            log.debug("book.hardcover is empty");
            MediaMultipartFile hardcoverMediaMultipartFile = new MediaMultipartFile(book.getHardcoverFile());
            bookForm.setHardcoverFile(hardcoverMediaMultipartFile);
        }
        if (bookForm.getBookFile().isEmpty()) {
            log.debug("book.bookFile is empty");
            MediaMultipartFile bookMediaMultipartFile = new MediaMultipartFile(book.getBookFile());
            bookForm.setBookFile(bookMediaMultipartFile);
        }
        log.debug("previous media was added.");
        bookFormValidator.validate(bookForm, bindingResult);
        if (bindingResult.hasErrors()) {
            log.debug("BookForm is NOT valid.");
            return "edit-book";
        }

        Book editedBook = bookMapper.map(bookForm, book.getUser());
        bookService.updateWithFields(editedBook);

        return "redirect:/book/" + id;
    }
}
