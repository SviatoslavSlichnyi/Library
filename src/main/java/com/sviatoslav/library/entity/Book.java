package com.sviatoslav.library.entity;

import com.sviatoslav.library.controller.mapper.MediaMapper;
import lombok.*;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.HashSet;
import java.util.Set;

@Data
@RequiredArgsConstructor
@AllArgsConstructor
@NoArgsConstructor
@Builder

@Entity
public class Book {

    @Id
    @GeneratedValue
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

    @OneToMany(targetEntity = Bucket.class, cascade = CascadeType.ALL)
    @Builder.Default
    @EqualsAndHashCode.Exclude
    @Transient private Set<Bucket> bucket = new HashSet<>();

    public void setHardcover(MultipartFile multipartFile) {
        this.hardcoverFile = new MediaMapper().map(multipartFile);
    }

    public void setMultipartFile(MultipartFile multipartFile) {
        this.bookFile = new MediaMapper().map(multipartFile);
    }

}
