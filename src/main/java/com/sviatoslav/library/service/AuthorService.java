package com.sviatoslav.library.service;

import com.sviatoslav.library.entity.Author;

import java.util.Optional;

public interface AuthorService extends CrudService<Author, Long> {
    Author findByFirstNameAndLastName(String firstName, String lastName);

    boolean existsByFirstNameAndLastName(String firstName, String lastName);
}
