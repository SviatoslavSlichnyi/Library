package com.sviatoslav.library.repository;

import com.sviatoslav.library.entity.Author;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepository extends JpaRepository<Author, Long> {

}
