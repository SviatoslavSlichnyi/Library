package com.sviatoslav.library.controller.mapper;

import com.sviatoslav.library.entity.Author;
import com.sviatoslav.library.service.AuthorService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor

@Component
public class AuthorMapper {

    private final AuthorService authorService;

    public Author map(String firstName, String lastName) {
        if (authorService.existsByFirstNameAndLastName(firstName, lastName)) {
            return authorService.findByFirstNameAndLastName(firstName, lastName);
        } else {
            return Author.builder()
                    .firstName(firstName)
                    .lastName(lastName)
                    .build();
        }
    }
}
