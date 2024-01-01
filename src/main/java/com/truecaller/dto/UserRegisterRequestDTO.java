package com.truecaller.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class UserRegisterRequestDTO {
    private String name;
    private String phoneNumber;

    @NotBlank(message = "email cannot be null")
    @Email(message = "Invalid  email format")
    private String email;

    @NotBlank(message = "Password cannot be blank")
    @Size(min = 8, message = "Password must be at least 8 characters long")
    private String password;


}
