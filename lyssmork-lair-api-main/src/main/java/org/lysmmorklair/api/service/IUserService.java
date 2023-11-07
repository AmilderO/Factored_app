package org.lysmmorklair.api.service;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.lysmmorklair.api.model.dto.response.UserResponse;

public interface IUserService {

    Page<UserResponse> getAll(Pageable pageable);
    Optional<UserResponse> getById(Integer id);
    void delete(Integer id);
    
}
