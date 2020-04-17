package com.sviatoslav.library.service.impl;

import com.sviatoslav.library.entity.Book;
import com.sviatoslav.library.entity.Bucket;
import com.sviatoslav.library.repository.BucketRepository;
import com.sviatoslav.library.service.BucketService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@RequiredArgsConstructor

@Service
public class BucketServiceImpl implements BucketService {

    private final BucketRepository bucketRepository;

    @Override
    public boolean existsByBookId(Long bookId) {
        return bucketRepository.existsByBookId(bookId);
    }

    @Override
    public boolean existsByUserIdAndProductId(Long userId, Long bookId) {
        return bucketRepository.existsByUserIdAndBookId(userId, bookId);
    }

    @Override
    public List<Book> findBooksByUserId(Long userId) {
        return bucketRepository.findBooksByUserId(userId);
    }

    @Override
    public void deleteByUserIdAndProductId(Long userId, Long bookId) {
        bucketRepository.deleteByUserIdAndBookId(userId, bookId);
    }

    @Override
    public Bucket save(Bucket bucket) {
        return bucketRepository.save(bucket);
    }

    @Override
    public Bucket findById(Long id) {
        return bucketRepository.findById(id).orElseThrow(
                () -> new EntityNotFoundException("Bucket with id \""+id+"\" was NOT found."));
    }

    @Override
    public Bucket update(Bucket bucket) {
        return bucketRepository.save(bucket);
    }

    @Override
    public void deleteById(Long id) {
        bucketRepository.deleteById(id);
    }

    @Override
    public void deleteAll() {
        bucketRepository.deleteAll();
    }

    @Override
    public List<Bucket> findAll() {
        return bucketRepository.findAll();
    }
}
