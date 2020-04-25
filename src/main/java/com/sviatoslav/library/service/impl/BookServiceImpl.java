package com.sviatoslav.library.service.impl;

import com.sviatoslav.library.entity.Book;
import com.sviatoslav.library.repository.*;
import com.sviatoslav.library.service.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;
import java.util.List;

@RequiredArgsConstructor

@Service
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;
    private final AuthorService authorService;
    private final MediaService mediaService;
    private final UserService userService;
    private final SavedBookService savedBookService;

    @Override
    public Book save(Book book) {
        return bookRepository.save(book);
    }

    @Override
    public Book findById(Long id) {
        return bookRepository.findById(id).orElseThrow(
                () -> new EntityNotFoundException(String.format("Book with id \"%d\" was NOT found.", id)));
    }

    @Override
    public Book update(Book book) {
        return bookRepository.save(book);
    }

    @Override
    public void deleteById(Long id) {
        bookRepository.deleteById(id);
    }

    @Override
    public void deleteAll() {
        bookRepository.deleteAll();
    }

    @Transactional
    @Override
    public void deleteFromBooksAndSavedBooks(Long id) {
        savedBookService.deleteSavedBooksByBookId(id);
        bookRepository.deleteById(id);
    }

    @Transactional
    @Override
    public void deleteFromBooksAndSavedBooksByUserId(Long userId) {
        savedBookService.deleteSavedBooksByUserId(userId);
        bookRepository.deleteByUser_Id(userId);
    }

    @Override
    public List<Book> findAll() {
        return bookRepository.findAll();
    }

    @Override
    public List<Book> findByUsername(String username) {
        return bookRepository.findBooksByUser_Username(username);
    }

    @Override
    public Book saveBookAndFields(Book book) {
        userService.save(book.getUser());
        authorService.save(book.getAuthor());
        mediaService.save(book.getHardcoverFile());
        mediaService.save(book.getBookFile());

        return bookRepository.save(book);
    }

    @Override
    public Book updateWithFields(Book book) {
        return saveBookAndFields(book);
    }
}
