package com.sviatoslav.library.repository;

import com.sviatoslav.library.entity.Role;
import com.sviatoslav.library.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface RoleRepository extends JpaRepository<Role, Long> {
}
