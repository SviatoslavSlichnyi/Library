package com.sviatoslav.library.service.impl;

import com.sviatoslav.library.entity.Book;
import com.sviatoslav.library.repository.AuthorRepository;
import com.sviatoslav.library.repository.BookRepository;
import com.sviatoslav.library.repository.MediaRepository;
import com.sviatoslav.library.repository.UserRepository;
import com.sviatoslav.library.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@RequiredArgsConstructor

@Service
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;
    private final MediaRepository mediaRepository;
    private final UserRepository userRepository;

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

    @Override
    public List<Book> findAll() {
        return bookRepository.findAll();
    }

    @Override
    public List<Book> findByUsername(String username) {
        return bookRepository.findByUsername(username);
    }

    @Override
    public Book saveBookAndFields(Book book) {
        authorRepository.save(book.getAuthor());
        userRepository.save(book.getUser());
        mediaRepository.save(book.getHardcoverFile());
        mediaRepository.save(book.getBookFile());

        return bookRepository.save(book);
    }

    @Override
    public Book updateWithFields(Book book) {
        return saveBookAndFields(book);
    }
}
