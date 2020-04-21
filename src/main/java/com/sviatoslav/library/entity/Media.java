package com.sviatoslav.library.entity;

import lombok.*;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder

@Entity
public class Media {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NonNull
    @Column(unique = true, nullable = false)
    private String name;

    @NonNull
    @Column(nullable = false)
    private String originalFilename;

    @NonNull
    @Column(nullable = false)
    private String contentType;

    @Lob
    private byte[] data;
}
