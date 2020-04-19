package com.sviatoslav.library.service.impl;

import com.sviatoslav.library.entity.Author;
import com.sviatoslav.library.repository.AuthorRepository;
import com.sviatoslav.library.service.AuthorService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@RequiredArgsConstructor

@Service
public class AuthorServiceImpl implements AuthorService {

    private final AuthorRepository authorRepository;

    @Override
    public Author save(Author author) {
        return authorRepository.save(author);
    }

    @Override
    public Author findById(Long id) {
        return authorRepository.findById(id).orElseThrow(
                () -> new EntityNotFoundException("Author with id \""+id+"\" was NOT found."));
    }

    @Override
    public Author update(Author author) {
        return authorRepository.save(author);
    }

    @Override
    public void deleteById(Long id) {
        authorRepository.deleteById(id);
    }

    @Override
    public void deleteAll() {
        authorRepository.deleteAll();
    }

    @Override
    public List<Author> findAll() {
        return authorRepository.findAll();
    }
}
