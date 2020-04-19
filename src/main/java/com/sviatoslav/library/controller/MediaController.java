package com.sviatoslav.library.controller;

import com.sviatoslav.library.entity.Media;
import com.sviatoslav.library.service.MediaService;
import lombok.RequiredArgsConstructor;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RequiredArgsConstructor

@Controller
public class MediaController {

    private final MediaService mediaService;

    @GetMapping("/media/{id}")
    public ResponseEntity<Resource> getFile(@PathVariable Long id) {
        Media media = mediaService.findById(id);

        return ResponseEntity.status(HttpStatus.OK)
                .header("Content-Disposition", "attachment; filename="+media.getOriginalFilename())
                .contentType(MediaType.parseMediaType(media.getContentType()))
                .body(new ByteArrayResource(media.getData()));
    }

}
