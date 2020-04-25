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

    private final UserService userService;

    @Value("${validator.userform.password.length.min}")
    private int minPasswordLength;

    @Override
    public boolean supports(Class<?> clazz) {
        return UserFormValidator.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "username", "validator.user-form.username.not.empty");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "email", "validator.user-form.email.not.empty");

        UserForm userForm = (UserForm) target;

        if (userService.existsByUsername(userForm.getUsername())) {
            errors.rejectValue("username",
                    "validator.user-form.username.already.exists");
        }

        if (userService.existsByEmail(userForm.getEmail())) {
            errors.rejectValue("email",
                    "validator.user-form.email.already.exists");
        }

        String password = userForm.getPassword();
        String passwordConfirm = userForm.getPasswordConfirm();

        if (password.isEmpty()) {
            errors.rejectValue("password",
                    "validator.user-from.password.not.empty");
        }

        if (passwordConfirm.isEmpty()) {
            ValidationUtils.rejectIfEmptyOrWhitespace(errors, "passwordConfirm", "validator.user-from.password.not.empty");
        }
        else if (password.length() < minPasswordLength) {
            errors.rejectValue("password", "validator.user-form.size.password");
        }
        else if (!password.equals(passwordConfirm)) {
            errors.rejectValue("passwordConfirm", "validator.user-form.diff.password-confirm");
        }
    }
}
