package com.sviatoslav.library.entity;

import lombok.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
public class BookForm {

    private Long id;

    @NotEmpty
    private String name;

    @NotEmpty
    private String authorFirstName;

    @NotEmpty
    private String authorLastName;

    @NotEmpty
    private String publisher;

    @NotNull
    @Min(0L)
    private Integer publicationYear;

    @NotNull
    @Min(0L)
    private Integer numberOfPages;

    @NotEmpty
    private String language;

    @NotEmpty
    private String description;

    @NotNull
    private MultipartFile hardcoverFile;

    @NotNull
    private MultipartFile bookFile;

}
