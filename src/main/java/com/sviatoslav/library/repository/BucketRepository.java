package com.sviatoslav.library.repository;

import com.sviatoslav.library.entity.Book;
import com.sviatoslav.library.entity.Bucket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface BucketRepository extends JpaRepository<Bucket, Long> {

    boolean existsByBookId(Long productId);

    boolean existsByUserIdAndBookId(Long userId, Long productId);

    @Query("select b.book from Bucket b where b.user.id = ?1")
    List<Book> findBooksByUserId(Long userId);

    void deleteByUserIdAndBookId(Long userId, Long productId);

}
