package com.userManagement.userManagementService.controller;
import com.userManagement.userManagementService.dto.SignupDto;
import com.userManagement.userManagementService.dto.UserLoginDto;
import com.userManagement.userManagementService.model.UserModel;
import com.userManagement.userManagementService.repository.UserRepository;
import com.userManagement.userManagementService.service.impl.UserServiceImpl;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@RestController
@RequestMapping("/user")
@Validated
public class UserController {
    @Autowired
    UserRepository userRepository;
    @Autowired
    UserServiceImpl userService;
    @PostMapping("/signup")
    public ResponseEntity<List<String>> createUser(@Valid @RequestBody SignupDto newUser) {
        return userService.createUser(newUser);
    }

    @GetMapping("/get-all-user")
    public ResponseEntity<List<UserModel>> getAllUser() {
        return userService.getAllUser();
    }

    @GetMapping("/get-user")
    public ResponseEntity<?> getUserByID(
            @RequestParam("id")
            @NotNull(message = "userID can not be null")
            @Positive(message = "User ID must be a positive integer")
            Long userID
    ) {
        return userService.getUserById(userID);
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@Valid @RequestBody UserLoginDto user) {
        return userService.login(user.getEmail(), user.getPassword());
    }
}