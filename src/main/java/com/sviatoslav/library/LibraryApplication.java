package com.sviatoslav.library;

import com.sviatoslav.library.entity.Role;
import com.sviatoslav.library.entity.User;
import com.sviatoslav.library.entity.enumeration.UserRole;
import com.sviatoslav.library.service.RoleService;
import com.sviatoslav.library.service.UserService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class LibraryApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(LibraryApplication.class, args);

        UserService userService = context.getBean(UserService.class);
        RoleService roleService = context.getBean(RoleService.class);

        Role roleAdmin;
        Role roleUser;
        roleAdmin = roleService.find(UserRole.ROLE_ADMIN);
        roleUser = roleService.find(UserRole.ROLE_USER);

        User admin = new User();
        admin.setId(1L);
        admin.setUsername("admin");
        admin.setEmail("admin@mail.com");
        admin.setPassword("adminAccess");
        admin.addRole(roleAdmin);
//        admin.addRole(roleUser);


        User user = User.builder()
                .id(2L)
                .email("steve.jobs@gmail.com")
                .username("apple-lover")
                .firstName("Steve")
                .lastName("Jobs")
                .password("iloveapples")
                .build();
        user.addRole(roleUser);

        userService.saveAndEncrypt(admin);
        userService.saveAndEncrypt(user);

    }

}
