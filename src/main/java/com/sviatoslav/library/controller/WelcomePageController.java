package com.sviatoslav.library.controller;

import com.sviatoslav.library.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.security.Principal;
import java.util.Optional;

@Controller
@Slf4j
public class WelcomePageController {
    @GetMapping("/")
    public String getWelcomePage(Principal principal, Model model) {
        String username = null;

        Optional<Principal> principalOpt = Optional.ofNullable(principal);

        if (principalOpt.isPresent()) {
            username = principal.getName();
        }

        model.addAttribute("username", username);

        return "index";
    }
}
