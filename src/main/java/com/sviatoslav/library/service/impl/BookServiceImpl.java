package com.sviatoslav.library.service.impl;

import com.sviatoslav.library.entity.Book;
import com.sviatoslav.library.repository.BookRepository;
import com.sviatoslav.library.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@RequiredArgsConstructor

@Service
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;

    @Override
    public Book save(Book book) {
        return bookRepository.save(book);
    }

    @Override
    public Book findById(Long id) {
        return bookRepository.findById(id).orElseThrow(
                () -> new EntityNotFoundException("Book with id \""+id+"\" was NOT found."));
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
}