package com.sviatoslav.library.entity;

import lombok.*;

import javax.persistence.Entity;
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
    private Long id;

    @NonNull
    @NotNull
    private String firstName;

    @NonNull
    @NotNull
    private String lastName;

    public Long getId() {
        return (long) this.hashCode();
    }

    public void generateAndSetId() {
        this.id = (long) hashCode();
    }


    @Override
    public String toString() {
        return firstName + " " + lastName;
    }
}
