package com.sviatoslav.library.response;

import lombok.Data;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@Data
public class MediaResponse {

    private String fileName;
    private String url;

    public MediaResponse(String fileName) {
        this.fileName = fileName;
        this.url = generateUrl(fileName);
    }

    private String generateUrl(String name) {
        return ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/"+name).toUriString();
    }
}
