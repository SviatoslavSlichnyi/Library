package com.sviatoslav.library.repository;

import com.sviatoslav.library.entity.Book;
import com.sviatoslav.library.entity.SavedBooks;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface SavedBooksRepository extends JpaRepository<SavedBooks, Long> {

    boolean existsByBook_IdAndUser_Id(Long bookId, Long userId);

    Optional<SavedBooks> findByBook_IdAndUser_Username(Long bookId, String username);

    @Query("SELECT sb.book FROM SavedBooks sb WHERE sb.user.id=:userId")
    List<Book> findBooksByUserId(@Param("userId") Long userId);

    @Query("SELECT sb.book FROM SavedBooks sb WHERE sb.user.username=:username")
    List<Book> findBooksByUsername(@Param("username") String username);

    void deleteSavedBooksByBook_Id(Long bookId);
}
