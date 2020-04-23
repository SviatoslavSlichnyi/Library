package com.sviatoslav.library.service;

import com.sviatoslav.library.entity.Author;

public interface AuthorService extends CrudService<Author, Long> {

    Author findByFirstNameAndLastName(String firstName, String lastName);

    boolean existsByFirstNameAndLastName(String firstName, String lastName);
}
