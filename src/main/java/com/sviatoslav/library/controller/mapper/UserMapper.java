package com.sviatoslav.library.controller.mapper;

import com.sviatoslav.library.entity.User;
import com.sviatoslav.library.entity.form.UserForm;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {
    public User map(UserForm userForm) {
        return User.builder()
                .id(userForm.getId())
                .username(userForm.getUsername())
                .firstName(userForm.getFirstName())
                .lastName(userForm.getLastName())
                .email(userForm.getEmail())
                .password(userForm.getPassword())
                .build();
    }
}
