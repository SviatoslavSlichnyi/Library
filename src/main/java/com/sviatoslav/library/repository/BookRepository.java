package com.sviatoslav.library.repository;

import com.sviatoslav.library.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface BookRepository extends JpaRepository<Book, Long> {
    @Query("SELECT b FROM Book b WHERE b.user.username = :username")
    List<Book> findByUsername(@Param("username") String username);
}
