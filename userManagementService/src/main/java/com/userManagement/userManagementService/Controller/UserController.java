package com.userManagement.userManagementService.Controller;
import com.userManagement.userManagementService.DTO.User.SignupDTO;
import com.userManagement.userManagementService.DTO.User.UserLoginDTO;
import com.userManagement.userManagementService.Model.UserModel;
import com.userManagement.userManagementService.Repository.UserRepository;
import com.userManagement.userManagementService.Service.UserService;
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
    UserService userService;
    @PostMapping("/signup")
    public ResponseEntity<List<String>> createUser(@Valid @RequestBody SignupDTO newUser) {
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
    public ResponseEntity<?> login(@Valid @RequestBody UserLoginDTO user) {
        return userService.login(user.getEmail(), user.getPassword());
    }
}