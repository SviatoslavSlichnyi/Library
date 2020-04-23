package com.sviatoslav.library.service.impl;

import com.sviatoslav.library.entity.Book;
import com.sviatoslav.library.entity.SavedBook;
import com.sviatoslav.library.repository.SavedBookRepository;
import com.sviatoslav.library.service.SavedBookService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;
import java.util.List;

@RequiredArgsConstructor

@Service
public class SavedBookServiceImpl implements SavedBookService {

    private final SavedBookRepository savedBookRepository;

    @Override
    public SavedBook save(SavedBook savedBook) {
        return savedBookRepository.save(savedBook);
    }

    @Override
    public SavedBook findById(Long id) {
        return savedBookRepository.findById(id).orElseThrow(
                () -> new EntityNotFoundException(String.format("SavedBooks with id \"%d\" was NOT found.", id)));
    }

    @Override
    public SavedBook update(SavedBook savedBook) {
        return savedBookRepository.save(savedBook);
    }

    @Override
    public void deleteById(Long id) {
        savedBookRepository.deleteById(id);
    }

    @Override
    public void deleteAll() {
        savedBookRepository.deleteAll();
    }

    @Override
    public List<SavedBook> findAll() {
        return savedBookRepository.findAll();
    }

    @Override
    public boolean existsByBookIdAndUsername(Long bookId, String username) {
        return savedBookRepository.existsByBook_IdAndUser_Username(bookId, username);
    }

    @Override
    public SavedBook findByBookIdAndUserUsername(Long bookId, String username) {
        return savedBookRepository.findByBook_IdAndUser_Username(bookId, username).orElseThrow(
                () -> new EntityNotFoundException(
                        String.format("SavedBooks with book_id: \"%d\" and user_username: \"%s\" was NOT found.",
                                bookId, username)));
    }

    @Override
    public List<Book> findBooksByUserId(Long id) {
        return savedBookRepository.findBooksByUserId(id);
    }

    @Override
    public List<Book> findBooksByUsername(String username) {
        return savedBookRepository.findBooksByUsername(username);
    }

    @Override
    public void delete(SavedBook savedBook) {
        savedBookRepository.delete(savedBook);
    }

    @Override
    public void deleteSavedBooksByBookId(Long id) {
        savedBookRepository.deleteSavedBooksByBook_Id(id);
    }

    @Transactional
    @Override
    public void deleteByBookIdAndUserUsername(Long bookId, String username) {
        savedBookRepository.deleteByBook_IdAndUser_Username(bookId, username);
    }
}
