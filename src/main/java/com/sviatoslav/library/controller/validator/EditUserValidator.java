package com.sviatoslav.library.controller.validator;

import com.sviatoslav.library.entity.form.EditUserForm;
import com.sviatoslav.library.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@RequiredArgsConstructor

@Component
public class EditUserValidator implements Validator {

    private final UserService userService;

    @Override
    public boolean supports(Class<?> clazz) {
        return EditUserForm.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        EditUserForm editUserForm = (EditUserForm) target;

        String username = editUserForm.getUsername();
        String currentUsername = editUserForm.getCurrentUser().getUsername();

        if (!currentUsername.equals(username) && userService.existsByUsername(username)) {
            errors.rejectValue("username",
                    "validator.user-form.username.already.exists");
        }
    }
}
