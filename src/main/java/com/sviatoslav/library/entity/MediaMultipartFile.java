package com.sviatoslav.library.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MediaMultipartFile implements MultipartFile {

    private Long id;
    private String name;
    private String originalFilename;
    private String contentType;
    private byte[] data;

    public MediaMultipartFile(Media media) {
        this.id = media.getId();
        this.name = media.getName();
        this.originalFilename = media.getOriginalFilename();
        this.contentType = media.getContentType();
        this.data = media.getData();
    }

    @Override
    public boolean isEmpty() {
        return 0 == data.length;
    }

    @Override
    public long getSize() {
        return data.length;
    }

    @Override
    public byte[] getBytes() throws IOException {
        if (data == null) {
            throw new IOException();
        } else {
            return data;
        }
    }

    @Override
    public InputStream getInputStream() {
        return new ByteArrayInputStream(data);
    }

    @Override
    public void transferTo(File dest) throws IllegalStateException {
        throw new RuntimeException("This method is NOT written.");
    }
}
