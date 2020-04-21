package com.sviatoslav.library.service;

import com.sviatoslav.library.entity.Role;
import com.sviatoslav.library.entity.enumeration.UserRole;

public interface RoleService extends CrudService<Role, Long> {
    Role find(UserRole role);
}
