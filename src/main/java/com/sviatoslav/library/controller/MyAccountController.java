package com.sviatoslav.library.controller;

import com.sviatoslav.library.controller.mapper.EditUserMapper;
import com.sviatoslav.library.controller.validator.EditUserValidator;
import com.sviatoslav.library.entity.User;
import com.sviatoslav.library.entity.form.EditUserForm;
import com.sviatoslav.library.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import java.security.Principal;

@RequiredArgsConstructor

@Controller
public class MyAccountController {

    private final UserService userService;
    private final EditUserMapper editUserMapper;
    private final EditUserValidator editUserValidator;

    @GetMapping("/my-account")
    public String getAccountPage(Principal principal, Model model) {
        String username = principal.getName();
        User user = userService.findByUsername(username);

        model.addAttribute("user", user);
        return "account";
    }

    @GetMapping("/my-account/edit")
    public String getEditMyAccountPage(Principal principal, Model model) {
        String username = principal.getName();
        User user = userService.findByUsername(username);

        EditUserForm editUserForm = editUserMapper.map(user);

        model.addAttribute("user", user);
        model.addAttribute("editUserForm", editUserForm);

        return "edit-account";
    }

    @PostMapping("/my-account/edit")
    public String editAccount(@Valid @ModelAttribute EditUserForm editUserForm,
                              Principal principal,
                              Model model,
                              BindingResult bindingResult) {

        String username = principal.getName();
        User user = userService.findByUsername(username);
        editUserForm.setCurrentUser(user);

        editUserValidator.validate(editUserForm, bindingResult);
        if (bindingResult.hasErrors()) {
            model.addAttribute("user", user);
            return "edit-account";
        }

        User editedUser = editUserMapper.map(user, editUserForm);
        userService.update(editedUser);

        return "redirect:/logout";
    }
}
