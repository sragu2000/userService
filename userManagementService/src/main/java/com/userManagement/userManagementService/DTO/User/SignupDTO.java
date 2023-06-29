package com.userManagement.userManagementService.DTO.User;
import jakarta.persistence.Column;
import jakarta.validation.constraints.*;
import lombok.Data;
@Data
public class SignupDTO {
    public SignupDTO() {
        fname = null;
        lname = null;
        phone = null;
        address = null;
        email = null;
    }

    @NotNull(message = "First Name can't be null")
    @NotBlank(message = "First Name can't be empty")
    private String fname;

    @NotNull(message = "Last Name can't be null")
    @NotBlank(message = "Last Name can't be empty")
    private String lname;

    @NotNull(message = "Email can't be null")
    @NotBlank(message = "Email can't be empty")
    @Pattern(regexp = "^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,4}$", message = "Invalid email address")
    private String email;

    @NotNull(message = "Address can't be null")
    @NotBlank(message = "Address can't be empty")
    private String address;

    @NotNull(message = "Phone Number can't be null")
    @NotBlank(message = "Phone Number can't be empty")
    @Positive(message = "Phone Number must be a positive value")
    @Pattern(regexp = "\\d{10}", message = "Invalid phone number")
    private String phone;

    @Column(name = "password")
    private String password;
}
