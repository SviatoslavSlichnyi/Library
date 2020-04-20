package com.sviatoslav.library.controller;

import com.sviatoslav.library.controller.mapper.UserMapper;
import com.sviatoslav.library.controller.validator.UserFormValidator;
import com.sviatoslav.library.entity.Role;
import com.sviatoslav.library.entity.User;
import com.sviatoslav.library.entity.enumeration.UserRole;
import com.sviatoslav.library.entity.form.UserForm;
import com.sviatoslav.library.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@RequiredArgsConstructor

@Controller
public class RegistrationController {

    private final UserFormValidator userFormValidator;
    private final UserMapper userMapper;
    private final UserService userService;

    @GetMapping("/registration")
    public String getRegistrationPage(Model model) {
        model.addAttribute("userForm", new UserForm());
        return "registration";
    }

    @PostMapping("/registration")
    public String registerUser(@Valid @ModelAttribute UserForm userForm, BindingResult bindingResult) {
        userFormValidator.validate(userForm, bindingResult);

        if (bindingResult.hasErrors()) {
            return "registration";
        }

        User user = userMapper.map(userForm);
        user.addRole(new Role(UserRole.ROLE_USER));


        userService.save(user);

        return "redirect:/login";
    }

}
