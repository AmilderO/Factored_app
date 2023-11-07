package org.lysmmorklair.api.service;

import org.lysmmorklair.api.model.dto.request.LoginRequest;
import org.lysmmorklair.api.model.dto.response.AuthResponse;
import org.lysmmorklair.api.model.dto.request.RegisterRequest;

public interface IAuthService {

    AuthResponse login(LoginRequest request);
    AuthResponse register(RegisterRequest request);
    
}
