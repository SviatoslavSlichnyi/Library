package com.sviatoslav.library.service;

import com.sviatoslav.library.entity.User;

import java.util.Optional;

public interface UserService extends CrudService<User, Long> {

    User findByEmail(String email);

    User findByUsername(String username);

    boolean existsByEmail(String email);

    boolean existsByUsername(String username);

    Optional<Long> findIdByEmail(String email);
}
