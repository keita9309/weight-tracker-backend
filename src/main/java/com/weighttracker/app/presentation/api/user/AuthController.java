package com.weighttracker.app.presentation.api.user;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.weighttracker.app.application.user.dto.LoginRequest;
import com.weighttracker.app.application.user.dto.LoginResponse;
import com.weighttracker.app.application.user.dto.SignUpRequest;
import com.weighttracker.app.application.user.dto.SignUpResponse;
import com.weighttracker.app.application.user.usecase.LoginUseCase;
import com.weighttracker.app.application.user.usecase.SignUpUseCase;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private final LoginUseCase loginUseCase;
    private final SignUpUseCase signUpUseCase;

    public AuthController(LoginUseCase loginUseCase, SignUpUseCase signUpUseCase) {
        this.loginUseCase = loginUseCase;
		this.signUpUseCase = signUpUseCase;
    }

    @PostMapping("/login")
    public ResponseEntity<LoginResponse> login(@RequestBody LoginRequest request) {
        LoginResponse response = loginUseCase.execute(request);
        return ResponseEntity.ok(response);
    }
    
    @PostMapping("/signup")
    public ResponseEntity<SignUpResponse> signup(@RequestBody SignUpRequest request) {
        SignUpResponse response = signUpUseCase.execute(request);
        return ResponseEntity.ok(response);
    }
}