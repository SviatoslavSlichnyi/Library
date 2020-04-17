package com.sviatoslav.library.entity;

import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

@Data
@NoArgsConstructor
@RequiredArgsConstructor
@AllArgsConstructor
@Builder

@Entity
public class User implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Exclude
    private Long id;

    @NonNull
    @NotNull
    private String username;

    @NonNull
    @NotNull
    private String email;

    @NonNull
    private String firstName;

    @NonNull
    private String lastName;

    @NonNull
    @NotNull
    private String password;

    @Transient
    @EqualsAndHashCode.Exclude
    private String passwordConfirm;

    @ManyToMany(fetch = FetchType.EAGER)
    private Set<Role> roles = new HashSet<>();

    @EqualsAndHashCode.Exclude
    @OneToOne
    private Media icon;

    @OneToMany(targetEntity = Bucket.class, cascade = CascadeType.ALL)
    @Builder.Default
    @EqualsAndHashCode.Exclude
    @Transient private Set<Bucket> bucket = new HashSet<>();

    public boolean addRole(Role role) {
        return roles.add(role);
    }


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return roles;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
