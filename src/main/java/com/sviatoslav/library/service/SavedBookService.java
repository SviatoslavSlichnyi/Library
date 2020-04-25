package com.sviatoslav.library.service;

import com.sviatoslav.library.entity.Book;
import com.sviatoslav.library.entity.SavedBook;

import java.util.List;

public interface SavedBookService extends CrudService<SavedBook, Long> {

    boolean existsByBookIdAndUsername(Long bookId, String username);

    SavedBook findByBookIdAndUserUsername(Long bookId, String username);

    List<Book> findBooksByUserId(Long id);

    List<Book> findBooksByUsername(String username);

    void delete(SavedBook savedBook);

    void deleteSavedBooksByBookId(Long id);

    void deleteSavedBooksByUserId(Long userId);

    void deleteByBookIdAndUserUsername(Long bookId, String username);
}
