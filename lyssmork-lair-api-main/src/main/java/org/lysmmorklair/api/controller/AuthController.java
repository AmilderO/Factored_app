package org.lysmmorklair.api.controller;

import org.lysmmorklair.api.service.IAuthService;
import org.lysmmorklair.api.model.dto.request.LoginRequest;
import org.lysmmorklair.api.model.dto.response.AuthResponse;
import org.lysmmorklair.api.model.dto.request.RegisterRequest;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@Validated
@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    private final IAuthService authService;

    @PostMapping(value = "login")
    public ResponseEntity<AuthResponse> login(@Valid @RequestBody LoginRequest request) {
        return ResponseEntity.ok(authService.login(request));
    }

    @PostMapping(value = "register")
    public ResponseEntity<AuthResponse> register(@Valid @RequestBody RegisterRequest request) {
        
        return ResponseEntity.ok(authService.register(request));
    }

}
