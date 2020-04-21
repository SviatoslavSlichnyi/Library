package com.sviatoslav.library.controller;

import com.sviatoslav.library.entity.Role;
import com.sviatoslav.library.entity.User;
import com.sviatoslav.library.entity.enumeration.UserRole;
import com.sviatoslav.library.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.security.Principal;
import java.util.Optional;
import java.util.Set;

@RequiredArgsConstructor

@Controller
@Slf4j
public class NavigationBarController {

    private final UserService userService;

    @GetMapping("/nav-bar")
    public String getNavigationBar(Model model, Principal principal) {
        String username = null;
        boolean isAdmin = false;
        boolean isUser = false;

        Optional<Principal> principalOpt = Optional.ofNullable(principal);

        if (principalOpt.isPresent()) {
            username = principal.getName();
            User user = userService.findByUsername(username);
            Set<Role> roles = user.getRoles();
            isAdmin = roles.contains(new Role(UserRole.ROLE_ADMIN));
            isUser = roles.contains(new Role(UserRole.ROLE_USER));
        }

        model.addAttribute("username", username);
        model.addAttribute("isAdmin", isAdmin);
        model.addAttribute("isUser", isUser);

        return "nav-bar";
    }

}
