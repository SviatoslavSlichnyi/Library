package com.sviatoslav.library.repository;

import com.sviatoslav.library.entity.Book;
import com.sviatoslav.library.entity.SavedBook;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface SavedBookRepository extends JpaRepository<SavedBook, Long> {

    boolean existsByBook_IdAndUser_Username(Long bookId, String username);

    Optional<SavedBook> findByBook_IdAndUser_Username(Long bookId, String username);

    @Query("SELECT sb.book FROM SavedBook sb WHERE sb.user.id=:userId")
    List<Book> findBooksByUserId(@Param("userId") Long userId);

    @Query("SELECT sb.book FROM SavedBook sb WHERE sb.user.username=:username")
    List<Book> findBooksByUsername(@Param("username") String username);

    void deleteSavedBooksByBook_Id(Long bookId);

    void deleteByBook_IdAndUser_Username(Long bookId, String username);
}
