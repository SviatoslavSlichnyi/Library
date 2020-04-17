package com.sviatoslav.library.entity;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
@RequiredArgsConstructor
@AllArgsConstructor
@Builder

@Entity
public class Author {

    @Id
    @GeneratedValue
    @EqualsAndHashCode.Exclude
    private Long id;

    @NonNull
    @NotNull
    private String firstName;

    @NonNull
    @NotNull
    private String lastName;
}
