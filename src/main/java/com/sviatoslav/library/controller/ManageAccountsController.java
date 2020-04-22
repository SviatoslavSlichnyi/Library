package com.sviatoslav.library.controller;

import com.sviatoslav.library.entity.User;
import com.sviatoslav.library.entity.enumeration.UserRole;
import com.sviatoslav.library.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@RequiredArgsConstructor

@Controller
public class ManageAccountsController {

    private final UserService userService;

    @GetMapping("/admin/manage-accounts")
    public String getManageAccountsPage(Model model) {
        List<User> users = userService.findUsersByUserRole(UserRole.ROLE_USER);

        model.addAttribute("users", users);
        return "manage-accounts";
    }

    @GetMapping("/admin/account/{id}")
    public String getAccountPage(@PathVariable Long id, Model model) {
        User user = userService.findById(id);

        model.addAttribute("user", user);
        return "account";
    }

    @PostMapping("/admin/account/delete/{id}")
    public String deleteUser(@PathVariable Long id) {
        userService.deleteById(id);
        return "redirect:/admin/manage-accounts";
    }

}
