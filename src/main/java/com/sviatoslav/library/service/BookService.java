package com.sviatoslav.library.service;

import com.sviatoslav.library.entity.Book;

import java.util.List;

public interface BookService extends CrudService<Book, Long> {

    List<Book> findByUsername(String username);

    Book saveBookAndFields(Book book);

    Book updateWithFields(Book book);

    void deleteFromBooksAndSavedBooks(Long id);
}
