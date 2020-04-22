package com.sviatoslav.library.entity;

import lombok.*;

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
    private Long id;

    @NonNull
    @NotNull
    private String name;

    @NotNull
    @ManyToOne
    private Author author;

    @NonNull
    @NotNull
    @OneToOne
    private Media bookFile;

    @NonNull
    @NotNull
    @ManyToOne
    private User user;

    @NonNull
    private String publisher;

    private Integer publicationYear;

    private Integer numberOfPages;

    @NonNull
    private String language;

    @NonNull
    private String description;

    @NonNull
    @NotNull
    @OneToOne
    private Media hardcoverFile;
}
