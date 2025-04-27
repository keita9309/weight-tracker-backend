package com.weighttracker.app.application.user.usecase;

import org.springframework.stereotype.Service;

import com.weighttracker.app.application.user.dto.LoginRequest;
import com.weighttracker.app.application.user.dto.LoginResponse;
import com.weighttracker.app.domain.user.model.User;
import com.weighttracker.app.domain.user.service.AuthenticationService;
import com.weighttracker.app.infra.auth.JwtTokenProvider;

@Service
public class LoginUseCase {
    private final AuthenticationService authenticationService;
    private final JwtTokenProvider jwtTokenProvider;

    public LoginUseCase(AuthenticationService authenticationService, JwtTokenProvider jwtTokenProvider) {
        this.authenticationService = authenticationService;
        this.jwtTokenProvider = jwtTokenProvider;
    }

    public LoginResponse execute(LoginRequest request) {
        User user = authenticationService.authenticate(request.email(), request.password());
        String token = jwtTokenProvider.generateToken(user.getId());
        return new LoginResponse(token);
    }
}