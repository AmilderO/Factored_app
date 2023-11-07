package org.lysmmorklair.api.service.imp;

import java.util.Optional;

import org.lysmmorklair.api.model.entity.User;
import org.lysmmorklair.api.service.IUserService;
import org.lysmmorklair.api.repository.UserRepository;
import org.lysmmorklair.api.repository.TokenRepository;
import org.lysmmorklair.api.exception.NotFoundException;
import org.lysmmorklair.api.model.dto.response.UserResponse;

import org.modelmapper.ModelMapper;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Pageable;
import org.springframework.transaction.annotation.Transactional;

import lombok.RequiredArgsConstructor;

@Service
@Transactional
@RequiredArgsConstructor
public class UserService implements IUserService {

    private final UserRepository userRepository;
    private final TokenRepository tokenRepository;
    private final ModelMapper modelMapper;

    @Override
    @Transactional(readOnly = true)
    public Page<UserResponse> getAll(Pageable pageable) {
        Page<User> users = userRepository.findAll(pageable);
        return users.map(user -> modelMapper.map(user, UserResponse.class));
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<UserResponse> getById(Integer id) {
        Optional<User> user = userRepository.findById(id);
        if(!user.isPresent())
            throw new NotFoundException("User not found");
        return Optional.ofNullable(modelMapper.map(user, UserResponse.class));       
    }

    @Override
    public void delete(Integer id) {
        tokenRepository.deleteAllTokenByUser(id);
        userRepository.deleteById(id);
    }

}
