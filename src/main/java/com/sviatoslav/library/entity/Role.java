package com.sviatoslav.library.entity;

import com.sviatoslav.library.entity.enumeration.UserRole;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Data
@NoArgsConstructor
@RequiredArgsConstructor
@Builder

@Entity
@Table(name = "role")
public class Role implements GrantedAuthority {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NonNull
    private Long id;

    @NonNull
    @Column(nullable = false)
    private String name;

//    @ManyToMany(mappedBy = "roles", fetch = FetchType.EAGER)
//    private final Set<User> users = new HashSet<>();

    public Role(UserRole role) {
        this.id = role.getId();
        this.name = role.getName();
    }

    @Override
    public String getAuthority() {
        return getName();
    }
}
