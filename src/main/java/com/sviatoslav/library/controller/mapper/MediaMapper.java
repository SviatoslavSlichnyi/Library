package com.sviatoslav.library.controller.mapper;

import com.sviatoslav.library.entity.Media;
import com.sviatoslav.library.entity.MediaMultipartFile;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public class MediaMapper {

    public Media map(MultipartFile multipartFile) {
        Media media = new Media();
        media.setName(generateFilename());
        media.setOriginalFilename(multipartFile.getOriginalFilename());
        media.setContentType(multipartFile.getContentType());

        try {
            media.setData(multipartFile.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }

        return media;
    }

    public MultipartFile map(Media media) {
        MediaMultipartFile mediaMultipartFile = new MediaMultipartFile();
        mediaMultipartFile.setId(media.getId());
        mediaMultipartFile.setName(media.getName());
        mediaMultipartFile.setOriginalFilename(media.getOriginalFilename());
        mediaMultipartFile.setContentType(media.getContentType());
        mediaMultipartFile.setData(media.getData());
        return mediaMultipartFile;
    }

    private String generateFilename() {
        return String.valueOf(System.nanoTime());
    }

}
