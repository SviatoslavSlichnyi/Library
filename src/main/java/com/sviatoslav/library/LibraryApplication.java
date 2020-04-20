package com.sviatoslav.library;

import com.sviatoslav.library.entity.Role;
import com.sviatoslav.library.entity.User;
import com.sviatoslav.library.entity.enumeration.UserRole;
import com.sviatoslav.library.service.UserService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class LibraryApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(LibraryApplication.class, args);


        User admin = new User();
        admin.setId(1L);
        admin.setUsername("admin");
        admin.setEmail("admin@mail.com");
        admin.setPassword("adminAccess");
        admin.addRole(new Role(UserRole.ROLE_ADMIN));

        User user = User.builder()
                .email("steve.jobs@gmail.com")
                .username("apple-lover")
                .firstName("Steve")
                .lastName("Jobs")
                .password("iloveapples")
                .build();
        user.addRole(new Role(UserRole.ROLE_USER));

        UserService userService = context.getBean(UserService.class);
        userService.save(admin);
        userService.save(user);
    }

}
