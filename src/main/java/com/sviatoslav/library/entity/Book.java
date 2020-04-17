package com.sviatoslav.library.entity;

import lombok.*;

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
    private Media hardcover;

    @NonNull
    @OneToOne
    private Media bookFile;

    @OneToMany(targetEntity = Bucket.class, cascade = CascadeType.ALL)
    @Builder.Default
    @EqualsAndHashCode.Exclude
    @Transient private Set<Bucket> bucket = new HashSet<>();
}
