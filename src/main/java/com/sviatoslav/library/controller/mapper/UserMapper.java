package com.sviatoslav.library.controller.mapper;

import com.sviatoslav.library.entity.User;
import com.sviatoslav.library.entity.form.EditUserForm;
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

    public User map(User user, UserForm userForm) {
        user.setUsername(userForm.getUsername());
        user.setEmail(userForm.getEmail());
        user.setFirstName(userForm.getFirstName());
        user.setLastName(userForm.getLastName());

        return user;
    }

    public UserForm map(User user) {
        return UserForm.builder()
                .id(user.getId())
                .username(user.getUsername())
                .email(user.getEmail())
                .firstName(user.getFirstName())
                .lastName(user.getLastName())
                .build();
    }
}
