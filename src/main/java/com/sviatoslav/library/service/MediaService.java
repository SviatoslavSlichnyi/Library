package com.sviatoslav.library.service;

import com.sviatoslav.library.entity.Media;

public interface MediaService extends CrudService<Media, Long> {
    Media findByName(String name);
    boolean existsByName(String name);
}
