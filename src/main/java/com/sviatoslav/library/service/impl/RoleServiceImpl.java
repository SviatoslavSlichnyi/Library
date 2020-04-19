package com.sviatoslav.library.service.impl;

import com.sviatoslav.library.entity.Role;
import com.sviatoslav.library.repository.RoleRepository;
import com.sviatoslav.library.service.RoleService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@RequiredArgsConstructor

@Service
public class RoleServiceImpl implements RoleService {

    private final RoleRepository roleRepository;

    @Override
    public Role save(Role role) {
        return roleRepository.save(role);
    }

    @Override
    public Role findById(Long id) {
        return roleRepository.findById(id).orElseThrow(
                () -> new EntityNotFoundException("Role with id \""+id+"\" was NOT found."));
    }

    @Override
    public Role update(Role role) {
        return roleRepository.save(role);
    }

    @Override
    public void deleteById(Long id) {
        roleRepository.deleteById(id);
    }

    @Override
    public void deleteAll() {
        roleRepository.deleteAll();
    }

    @Override
    public List<Role> findAll() {
        return roleRepository.findAll();
    }
}
