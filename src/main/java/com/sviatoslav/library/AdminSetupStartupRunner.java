package com.sviatoslav.library;

import com.sviatoslav.library.entity.Role;
import com.sviatoslav.library.entity.User;
import com.sviatoslav.library.entity.enumeration.UserRole;
import com.sviatoslav.library.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor

@Component
@Slf4j
public class AdminSetupStartupRunner implements CommandLineRunner {

    private final UserService userService;

    @Override
    public void run(String... args) {
        if (!userService.existsByUsername("admin")) {
            User admin = new User();
            admin.setUsername("admin");
            admin.setEmail("admin@mail.com");
            admin.setPassword("adminAccess");
            admin.getRoles().add(new Role(UserRole.ROLE_ADMIN));

            userService.encryptAndSave(admin);
            log.debug("admin was added");
        }
    }
}
