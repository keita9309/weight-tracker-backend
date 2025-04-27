package com.weighttracker.app.application.user.usecase;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.weighttracker.app.application.user.dto.SignUpRequest;
import com.weighttracker.app.application.user.dto.SignUpResponse;
import com.weighttracker.app.domain.user.exception.DuplicateUserException;
import com.weighttracker.app.domain.user.model.Password;
import com.weighttracker.app.domain.user.model.User;
import com.weighttracker.app.domain.user.repository.UserRepository;

@Service
public class SignUpUseCase {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public SignUpUseCase(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public SignUpResponse execute(SignUpRequest request) {
        if (userRepository.findByEmail(request.email()).isPresent()) {
            throw new DuplicateUserException("Email already registered");
        }
        
        User user = User.createNewUser(
        	    request.username(),
        	    request.email(),
        	    new Password(passwordEncoder.encode(request.password())),
        	    request.firstName(),
        	    request.lastName()
        	);

        User savedUser = userRepository.insert(user);
        return new SignUpResponse(savedUser.getId());
    }
}
