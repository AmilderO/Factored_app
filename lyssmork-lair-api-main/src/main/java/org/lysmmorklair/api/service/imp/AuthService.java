package org.lysmmorklair.api.service.imp;

import org.lysmmorklair.api.model.entity.User;
import org.lysmmorklair.api.model.entity.Token;
import org.lysmmorklair.api.model.enums.UserRole;
import org.lysmmorklair.api.service.IAuthService;
import org.lysmmorklair.api.service.IJwtService;
import org.lysmmorklair.api.repository.UserRepository;
import org.lysmmorklair.api.repository.TokenRepository;
import org.lysmmorklair.api.exception.ConflictException;
import org.lysmmorklair.api.model.dto.request.LoginRequest;
import org.lysmmorklair.api.model.dto.response.AuthResponse;
import org.lysmmorklair.api.model.dto.request.RegisterRequest;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

import lombok.RequiredArgsConstructor;

@Service
@Transactional
@RequiredArgsConstructor
public class AuthService implements IAuthService {

    private final IJwtService jwtService;

    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;

    private final UserRepository userRepository;
    private final TokenRepository tokenRepository;

    public AuthResponse login(LoginRequest request) {
        authenticationManager
                .authenticate(new UsernamePasswordAuthenticationToken(request.getUsername(),
                        request.getPassword()));
        User user = userRepository.findByUsername(request.getUsername()).orElseThrow();
        String token = jwtService.getToken(user);
        tokenRepository.deleteAllTokenByUser(user.getId());
        saveUserToken(user, token);
        return AuthResponse.builder()
                .token(token)
                .build();

    }

    public AuthResponse register(RegisterRequest request) {
        User user = User.builder()
                .username(request.getUsername())
                .password(passwordEncoder.encode(request.getPassword()))
                .firstname(request.getFirstname())
                .lastname(request.getLastname())
                .email(request.getEmail())
                .role(UserRole.USER)
                .build();
        
        if(userRepository.findByUsername(user.getUsername()).isPresent()) {
            throw new ConflictException("Username already exists");
        }
        
        if(userRepository.findByEmail(user.getEmail()).isPresent()) {
            throw new ConflictException("Email already exists");
        }

        User savedUser = userRepository.save(user);
        
        String token = jwtService.getToken(savedUser);
        saveUserToken(savedUser, token);        

        return AuthResponse.builder()
                .token(token)
                .build();

    }

    private void saveUserToken(User user, String jwtToken) {
        var token = Token.builder()
                .user(user)
                .token(jwtToken)
                .build();
        tokenRepository.save(token);
    }

}