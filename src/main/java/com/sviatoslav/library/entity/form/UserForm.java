package com.sviatoslav.library.entity.form;

import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
public class UserForm {

    private Long id;

    @NotEmpty
    private String username;

    @NotEmpty
    @Email
    private String email;

    @NotNull
    private String firstName;

    @NotNull
    private String lastName;

    @NotEmpty
    private String password;

    @NotEmpty
    private String passwordConfirm;

}
