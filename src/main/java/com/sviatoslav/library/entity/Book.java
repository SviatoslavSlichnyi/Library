package com.sviatoslav.library.entity;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder

@Entity
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private String name;

    @NotNull
    @ManyToOne
    private Author author;

    private String publisher;

    private Integer publicationYear;

    private Integer numberOfPages;

    private String language;

    private String description;

    @NotNull
    @OneToOne
    private Media hardcoverFile;

    @NotNull
    @OneToOne
    private Media bookFile;

    @NotNull
    @ManyToOne
    private User user;
}
