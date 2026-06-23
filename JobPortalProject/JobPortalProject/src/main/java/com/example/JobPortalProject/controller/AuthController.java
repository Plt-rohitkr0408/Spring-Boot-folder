package com.example.JobPortalProject.controller;

import com.example.JobPortalProject.dto.AuthResponse;
import com.example.JobPortalProject.dto.LoginRequest;
import com.example.JobPortalProject.dto.RegisteRequest;
import com.example.JobPortalProject.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {
    private final AuthService authService;

    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody RegisteRequest registeRequest) {
        authService.register(registeRequest);
        return ResponseEntity.ok("User registered successfully");
    }

    @PostMapping("/login")
    public ResponseEntity<AuthResponse> login(@RequestBody LoginRequest loginRequest) {
        authService.login(loginRequest);
        return ResponseEntity.ok(authService.login(loginRequest));
    }
}
