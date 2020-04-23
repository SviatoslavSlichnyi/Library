package com.sviatoslav.library.repository;

import com.sviatoslav.library.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByEmail(String email);

    Optional<User> findByUsername(String username);

    boolean existsByEmail(String email);

    boolean existsByUsername(String username);

    @Query("SELECT u.id from User u where u.email=:email")
    Long findIdByEmail(@Param("email") String email);

    @Query("SELECT u FROM  User u join u.roles r WHERE r.name = ?1")
    List<User> findUsersByRole(String roleName);
}
