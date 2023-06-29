package com.userManagement.userManagementService.DTO.User;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Data;

@Data
public class GetuserDto {
    @NotNull(message = "User ID can't be null")
    @Positive(message = "User ID should be a positive number")
    private Long id;
}
