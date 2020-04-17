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
    @GeneratedValue
    private Long id;

    @NonNull
    @Column(unique = true, nullable = false)
    private String fileName;

    @NonNull
    @Column(nullable = false)
    private String type;

    @NonNull
    @Lob
    private byte[] data;
}
