package com.sviatoslav.library.controller.mapper;

import com.sviatoslav.library.entity.User;
import com.sviatoslav.library.entity.form.EditUserForm;
import org.springframework.stereotype.Component;

@Component
public class EditUserMapper {

    public EditUserForm map(User user) {
        return EditUserForm.builder()
                .username(user.getUsername())
                .firstName(user.getFirstName())
                .lastName(user.getLastName())
                .currentUser(user)
                .build();
    }

    public User map(User user, EditUserForm editUserForm) {
        user.setUsername(editUserForm.getUsername());
        user.setFirstName(editUserForm.getFirstName());
        user.setLastName(editUserForm.getLastName());

        return user;
    }
}
