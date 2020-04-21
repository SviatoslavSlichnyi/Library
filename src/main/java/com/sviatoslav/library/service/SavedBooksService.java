package com.sviatoslav.library.service;

import com.sviatoslav.library.entity.Book;
import com.sviatoslav.library.entity.SavedBooks;

import java.util.List;

public interface SavedBooksService extends CrudService<SavedBooks, Long> {

    boolean existsByBookIdAndUserId(Long bookId, Long userId);

    SavedBooks findByBookIdAndUserUsername(Long bookId, String username);

    List<Book> findBooksByUserId(Long userId);

    List<Book> findBooksByUsername(String username);

    void delete(SavedBooks savedBooks);
}
