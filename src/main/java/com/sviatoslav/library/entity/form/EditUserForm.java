package com.sviatoslav.library.entity.form;

import com.sviatoslav.library.entity.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class EditUserForm {

    @NotEmpty
    private String username;

    @NotNull
    private String firstName;

    @NotNull
    private String lastName;

    private User currentUser;
}
