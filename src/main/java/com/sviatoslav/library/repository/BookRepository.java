package com.sviatoslav.library.repository;

import com.sviatoslav.library.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookRepository extends JpaRepository<Book, Long> {
    List<Book> findBooksByUser_Username(String username);
}
