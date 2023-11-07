package org.lysmmorklair.api.model.dto.request;

import lombok.Data;
import lombok.Builder;
import lombok.NoArgsConstructor;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RegisterRequest {
    
    @NotBlank(message = "Username cannot be empty")
    String username;

    @NotBlank(message = "Password cannot be empty")
    String password;

    @NotBlank(message = "First name cannot be empty")
    String firstname;

    @NotBlank(message = "Last name cannot be empty")
    String lastname;

    @Email(message = "Email is not in expected format")
    @NotBlank(message = "Email cannot be empty")
    String email;

}
