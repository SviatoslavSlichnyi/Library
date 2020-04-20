package com.sviatoslav.library.entity;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@RequiredArgsConstructor
@AllArgsConstructor
@NoArgsConstructor
@Builder

@Entity
public class Bucket {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NonNull
    @ManyToOne
    private User user;

    @NonNull
    @ManyToOne
    private Book book;

    @NonNull
    @Column(nullable = false)
    private LocalDateTime purchaseDate;
}
