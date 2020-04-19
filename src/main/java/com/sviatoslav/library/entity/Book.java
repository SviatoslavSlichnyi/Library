package com.sviatoslav.library.entity;

import com.sviatoslav.library.controller.mapper.MediaMapper;
import lombok.*;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Data
@RequiredArgsConstructor
@AllArgsConstructor
@NoArgsConstructor
@Builder

@Entity
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Exclude
    private Long id;

    @NonNull
    @NotNull
    private String name;

    @NonNull
    @OneToOne
    private Author author;

    @NonNull
    private String publisher;

    @NonNull
    private Integer publicationYear;

    @NonNull
    private Integer numberOfPages;

    @NonNull
    private String language;

    @NonNull
    private String description;

    @OneToOne
    private Media hardcoverFile;

    @NonNull
    @OneToOne
    private Media bookFile;

    public void setHardcover(MultipartFile multipartFile) {
        this.hardcoverFile = new MediaMapper().map(multipartFile);
    }

    public void setMultipartFile(MultipartFile multipartFile) {
        this.bookFile = new MediaMapper().map(multipartFile);
    }

}
