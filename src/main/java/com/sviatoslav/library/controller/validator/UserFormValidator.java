package com.sviatoslav.library.controller.validator;

import com.sviatoslav.library.entity.form.UserForm;
import com.sviatoslav.library.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

@RequiredArgsConstructor

@Component
@PropertySource("classpath:validator.properties")
public class UserFormValidator implements Validator {

    @Value("${validator.userform.password.length.min}")
    private int minPasswordLength;

    private final UserService userService;

    @Override
    public boolean supports(Class<?> clazz) {
        return UserFormValidator.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "username", "user.name.not.empty");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "user.password.not.empty");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "passwordConfirm", "user.password.not.empty");

        UserForm userForm = (UserForm) target;

        if (userService.existsByUsername(userForm.getUsername())) {
            errors.rejectValue("username",
                    "user.username.already-exists",
                    "User with username \""+userForm.getUsername()+"\" already exist.");
        }

        if (userForm.getPassword().length() < minPasswordLength) {
            errors.rejectValue("password", "userForm.size.password");
        }
        else if (!userForm.getPassword().equals(userForm.getPasswordConfirm())) {
            errors.rejectValue("passwordConfirm", "userForm.diff.passwordConfirm");
        }
    }
}
