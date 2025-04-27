package com.weighttracker.app.domain.user.service;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.weighttracker.app.domain.user.exception.InvalidPasswordException;
import com.weighttracker.app.domain.user.model.User;
import com.weighttracker.app.domain.user.repository.UserRepository;


@Service
public class AuthenticationService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public AuthenticationService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public User authenticate(String email, String rawPassword) {
        return userRepository.findByEmail(email)
            .filter(user -> passwordEncoder.matches(rawPassword, user.getPassword().getValue()))
            .orElseThrow(() -> new InvalidPasswordException("Invalid email or password"));
    }
}