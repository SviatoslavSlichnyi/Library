package com.sviatoslav.library.controller.mapper;

import com.sviatoslav.library.entity.Media;
import com.sviatoslav.library.entity.MediaMultipartFile;
import com.sviatoslav.library.service.MediaService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RequiredArgsConstructor

@Component
public class MediaMapper {

    private final MediaService mediaService;

    public Media map(MultipartFile multipartFile) {
        Media media;

        String name = multipartFile.getName();
        if (mediaService.existsByName(name)) {
            media = mediaService.findByName(name);
        } else {
            media = Media.builder()
                    .name(generateFilename())
                    .originalFilename(multipartFile.getOriginalFilename())
                    .contentType(multipartFile.getContentType())
                    .build();
            try {
                media.setData(multipartFile.getBytes());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return media;
    }

    public MultipartFile map(Media media) {
        return MediaMultipartFile.builder()
                .id(media.getId())
                .name(media.getName())
                .originalFilename(media.getOriginalFilename())
                .contentType(media.getContentType())
                .data(media.getData())
                .build();
    }

    private String generateFilename() {
        return String.valueOf(System.nanoTime());
    }

}
