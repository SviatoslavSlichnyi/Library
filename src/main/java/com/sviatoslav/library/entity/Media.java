package com.sviatoslav.library.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@RequiredArgsConstructor

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

    @NonNull
    @Lob
    private byte[] data;
}
