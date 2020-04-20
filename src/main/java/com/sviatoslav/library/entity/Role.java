package com.sviatoslav.library.entity;

import com.sviatoslav.library.entity.enumeration.UserRole;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;

@Data
@NoArgsConstructor
@RequiredArgsConstructor

@Entity
public class Role implements GrantedAuthority {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Exclude
    @NonNull
    private Long id;

    @NonNull
    @Column(nullable = false)
    private String name;

    public Role(UserRole role) {
        this.id = role.getId();
        this.name = role.getName();
    }

    @Override
    public String getAuthority() {
        return getName();
    }
}
