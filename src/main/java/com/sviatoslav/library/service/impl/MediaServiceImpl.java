package com.sviatoslav.library.service.impl;

import com.sviatoslav.library.entity.Media;
import com.sviatoslav.library.repository.MediaRepository;
import com.sviatoslav.library.service.MediaService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@RequiredArgsConstructor

@Service
public class MediaServiceImpl implements MediaService {

    private final MediaRepository mediaRepository;

    @Override
    public Media findByName(String name) {
        return mediaRepository.findByName(name).orElseThrow(
                () -> new EntityNotFoundException(String.format("Media with file name \"%s\" was NOT found.", name)));
    }

    @Override
    public boolean existsByName(String name) {
        return mediaRepository.existsByName(name);
    }

    @Override
    public Media save(Media media) {
        return mediaRepository.save(media);
    }

    @Override
    public Media findById(Long id) {
        return mediaRepository.findById(id).orElseThrow(
                () -> new EntityNotFoundException(String.format("Media with id \"%d\" was NOT found.", id)));
    }

    @Override
    public Media update(Media media) {
        return null;
    }

    @Override
    public void deleteById(Long id) {
        mediaRepository.deleteById(id);
    }

    @Override
    public void deleteAll() {
        mediaRepository.deleteAll();
    }

    @Override
    public List<Media> findAll() {
        return mediaRepository.findAll();
    }
}
