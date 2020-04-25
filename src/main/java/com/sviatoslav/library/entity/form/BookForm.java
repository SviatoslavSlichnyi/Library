package com.sviatoslav.library.entity.form;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BookForm {

    private Long id;

    @NotNull
    private String name;

    @NotNull
    private String authorFirstName;

    @NotNull
    private String authorLastName;

    @NotNull
    private String publisher;

    @Min(0L)
    private Integer publicationYear;

    @Min(0L)
    private Integer numberOfPages;

    @NotNull
    private String language;

    @NotNull
    private String description;

    @NotNull
    private MultipartFile hardcoverFile;

    @NotNull
    private MultipartFile bookFile;
}
