package com.sviatoslav.library.service.impl;

import com.sviatoslav.library.entity.Book;
import com.sviatoslav.library.entity.SavedBooks;
import com.sviatoslav.library.repository.SavedBooksRepository;
import com.sviatoslav.library.service.SavedBooksService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@RequiredArgsConstructor

@Service
public class SavedBooksServiceImpl implements SavedBooksService {

    private final SavedBooksRepository savedBooksRepository;

    @Override
    public SavedBooks save(SavedBooks savedBooks) {
        return savedBooksRepository.save(savedBooks);
    }

    @Override
    public SavedBooks findById(Long id) {
        return savedBooksRepository.findById(id).orElseThrow(
                () -> new EntityNotFoundException(String.format("SavedBooks with id \"%d\" was NOT found.", id)));
    }

    @Override
    public SavedBooks update(SavedBooks savedBooks) {
        return savedBooksRepository.save(savedBooks);
    }

    @Override
    public void deleteById(Long id) {
        savedBooksRepository.deleteById(id);
    }

    @Override
    public void deleteAll() {
        savedBooksRepository.deleteAll();
    }

    @Override
    public List<SavedBooks> findAll() {
        return savedBooksRepository.findAll();
    }

    @Override
    public boolean existsByBookIdAndUserId(Long bookId, Long userId) {
        return savedBooksRepository.existsByBook_IdAndUser_Id(bookId, userId);
    }

    @Override
    public SavedBooks findByBookIdAndUserUsername(Long bookId, String username) {
        return savedBooksRepository.findByBook_IdAndUser_Username(bookId, username).orElseThrow(
                () -> new EntityNotFoundException(
                        String.format("SavedBooks with book_id: \"%d\" and user_username: \"%s\" was NOT found.",
                                bookId, username)));
    }

    @Override
    public List<Book> findBooksByUserId(Long userId) {
        return savedBooksRepository.findBooksByUserId(userId);
    }

    @Override
    public List<Book> findBooksByUsername(String username) {
        return savedBooksRepository.findBooksByUsername(username);
    }

    @Override
    public void delete(SavedBooks savedBooks) {
        savedBooksRepository.delete(savedBooks);
    }
}
