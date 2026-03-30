package com.hieudev.ss8_validate_formlogin.dto;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {
    @NotBlank(message = "First name must not be blank")
    @Size(min = 1, max = 30,
            message = "First name must be between 1 and 30 characters")
    private String firstName;

    @NotBlank(message = "Last name must not be blank")
    @Size(min = 1, max = 30,
            message = "Last name must be between 1 and 30 characters")
    private String lastName;

    @NotBlank(message = "Phone number must not be blank")
    @Pattern(regexp = "^(012|013)\\d{7}$",
            message = "Phone number must start with 012 or 013 and be followed by 7 digits and end with a digit")
    private String phoneNumber;

    @NotBlank(message = "Email must not be blank")
    @Pattern(regexp = "^[a-z][a-z0-9]{5,20}@gmail\\.com", message = "Email must start with a lowercase letter, followed by 5 to 20 lowercase letters or digits, and end with @gmail.com")
    private String email;

    @NotNull(message = "Age must not be null")
    @Min(value = 18, message = "Age must be at least 18")
    @Max(value = 99, message = "Age must be at most 100")
    private Integer age;

    @NotBlank(message = "User name must not be blank")
    @Pattern(regexp = "^[a-zA-Z][a-z0-9]{7,20}$", message = "User name must start with a letter and be followed by 7 to 20 lowercase letters or digits")
    private String username;

    @NotBlank(message = "Pass word must not be blank")
    @Pattern(regexp = "^[\\da-z\\dA-Z\\d0-9\\d!@#$%^&*]{8,20}$",
            message = "Password must be between 8 and 20 characters and contain only letters, numbers, and special characters !@#$%^&*")
    private String password;
}
