package com.sviatoslav.library.entity;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.time.LocalDateTime;

@Data
@RequiredArgsConstructor
@AllArgsConstructor
@NoArgsConstructor
@Builder

@Entity
public class Bucket {

    @Id
    @GeneratedValue
    private Long id;

    @NonNull
    @ManyToOne
    private User user;

    @NonNull
    @ManyToOne
    private Book book;

    @NonNull
    private LocalDateTime purchaseDate;
}
