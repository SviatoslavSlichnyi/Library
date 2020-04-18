package com.sviatoslav.library.controller.mapper;

import com.sviatoslav.library.entity.Media;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public class MediaMapper {

    public Media map(MultipartFile multipartFile) {
        Media media = new Media();
        media.setFileName(generateFilename());
        media.setType(multipartFile.getContentType());
        try {
            media.setData(multipartFile.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }

        return media;
    }

    private String generateFilename() {
        return String.valueOf(System.nanoTime());
    }

}
