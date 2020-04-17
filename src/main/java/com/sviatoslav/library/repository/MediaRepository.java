package com.sviatoslav.library.repository;

import com.sviatoslav.library.entity.Media;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MediaRepository extends JpaRepository<Media, Long> {
    Optional<Media> findByFileName(String fileName);
}
