package com.userManagement.userManagementService.service;

import com.userManagement.userManagementService.dto.SignupDto;
import com.userManagement.userManagementService.model.UserModel;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface UserService {
    ResponseEntity<List<String>> createUser(SignupDto userData);
    ResponseEntity<List<UserModel>> getAllUser();
    ResponseEntity<?> login(String email, String password);
    ResponseEntity<?> getUserById(Long id);
}