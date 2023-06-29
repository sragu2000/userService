package com.userManagement.userManagementService.DTO.User;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Data
public class UserLoginDTO {

    @NotNull(message = "Email can't be null")
    @NotBlank(message = "Email can't be empty")
    @Pattern(regexp = "^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,4}$", message = "Invalid email address")
    private String email;


    @NotNull(message = "Password can't be null")
    @NotBlank(message = "Password can't be empty")
    private String password;
}