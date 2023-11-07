package org.lysmmorklair.api.model.dto.response;

import java.time.LocalDateTime;

import org.lysmmorklair.api.model.enums.UserRole;

import lombok.Data;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserResponse {

    private Integer id;
    private String firstname;
    private String lastname;
    private String email;
    private String username;
    private UserRole role;
    private LocalDateTime createdDate;
    private LocalDateTime modifiedDate;
    
}
