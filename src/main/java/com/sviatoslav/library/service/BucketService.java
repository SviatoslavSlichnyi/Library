package com.sviatoslav.library.service;

import com.sviatoslav.library.entity.Book;
import com.sviatoslav.library.entity.Bucket;

import java.util.List;

public interface BucketService extends CrudService<Bucket, Long> {

    boolean existsByBookId(Long bookId);

    boolean existsByUserIdAndProductId(Long userId, Long bookId);

    List<Book> findBooksByUserId(Long userId);

    void deleteByUserIdAndProductId(Long userId, Long bookId);

}
