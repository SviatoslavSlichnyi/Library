package com.sviatoslav.library.service;

import com.sviatoslav.library.entity.User;

import java.util.Optional;

public interface UserService extends CrudService<User, Long> {

    User findByEmail(String email);

    boolean existsByEmail(String email);

    Optional<Long> findIdByEmail(String email);

}
