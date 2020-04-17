package com.sviatoslav.library.entity;

import com.sviatoslav.library.entity.enumeration.UserRole;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@NoArgsConstructor
@RequiredArgsConstructor

@Entity
public class Role implements GrantedAuthority {

    @Id
    @NonNull
    @EqualsAndHashCode.Exclude
    private Long id;

    @NonNull
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
