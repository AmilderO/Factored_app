package org.lysmmorklair.api.model.dto.request;

import lombok.Data;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import jakarta.validation.constraints.NotBlank;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class LoginRequest {

    @NotBlank(message = "Username cannot be empty")
    String username;

    @NotBlank(message = "Password cannot be blank")
    String password;
    
}
