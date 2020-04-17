package com.sviatoslav.library.service;

import com.sviatoslav.library.entity.Media;

import java.util.Optional;

public interface MediaService extends CrudService<Media, Long> {
    Media findByFileName(String fileName);
}
