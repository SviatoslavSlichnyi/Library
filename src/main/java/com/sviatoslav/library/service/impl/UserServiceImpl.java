package com.sviatoslav.library.service.impl;

import com.sviatoslav.library.entity.User;
import com.sviatoslav.library.repository.UserRepository;
import com.sviatoslav.library.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public User findByEmail(String email) {
        return userRepository.findByEmail(email).orElseThrow(
                () -> new EntityNotFoundException("User with email \""+email+"\" was NOT found."));
    }

    @Override
    public boolean existsByEmail(String email) {
        return userRepository.existsByEmail(email);
    }

    @Override
    public Optional<Long> findIdByEmail(String email) {
        try {
            return Optional.of(userRepository.findIdByEmail(email));
        } catch (RuntimeException e) {
            return Optional.empty();
        }
    }

    @Override
    public User save(User user) {
        return userRepository.save(user);
    }

    @Override
    public User findById(Long id) {
        return userRepository.findById(id).orElseThrow(
                () -> new EntityNotFoundException("User with id \""+id+"\" was NOT found."));
    }

    @Override
    public User update(User user) {
        return userRepository.save(user);
    }

    @Override
    public void deleteById(Long id) {
        userRepository.deleteById(id);
    }

    @Override
    public void deleteAll() {
        userRepository.deleteAll();
    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }
}
