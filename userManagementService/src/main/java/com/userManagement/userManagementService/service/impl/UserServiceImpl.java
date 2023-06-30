package com.userManagement.userManagementService.service.impl;
import com.userManagement.userManagementService.dto.SignupDto;
import com.userManagement.userManagementService.model.UserModel;
import com.userManagement.userManagementService.repository.UserRepository;
import com.userManagement.userManagementService.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    private final ModelMapper modelMapper;

    @Autowired
    UserRepository userRepository;

    @Autowired
    public UserServiceImpl(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public ResponseEntity<List<String>> createUser(SignupDto userData) {
        try {
            UserModel newUser = modelMapper.map(userData, UserModel.class);
            List<String> userResponse = new ArrayList<>();
            List<UserModel> users = userRepository.findByEmail(newUser.getEmail());
            if (users.isEmpty()) {
                userResponse.add("User registered successfully");
                UserModel savedUser = userRepository.save(newUser);
                return new ResponseEntity<>(userResponse, HttpStatus.CREATED);
            } else {
                userResponse.add("User already exists");
                return new ResponseEntity<>(userResponse, HttpStatus.CONFLICT);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ResponseEntity<List<UserModel>> getAllUser() {
        try {
            return new ResponseEntity<>(userRepository.findAll(), HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ResponseEntity<?> login(String email, String password) {
        try {
            List<String> response = new ArrayList<>();
            List<UserModel> availableUser = userRepository.findByEmail(email);
            if (availableUser.isEmpty()) {
                response.add("User does not exist");
                return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
            } else {
                if (Objects.equals(availableUser.get(0).getPassword(), password)) {
                    response.add("Login Success");
                    return new ResponseEntity<>(response, HttpStatus.OK);
                } else {
                    response.add("Incorrect Password");
                    return new ResponseEntity<>(response, HttpStatus.UNAUTHORIZED);
                }
            }
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ResponseEntity<?> getUserById(Long id) {
        try{
            System.out.println("Hello World");
            Optional<UserModel> optionalUserModel = userRepository.findById(id);
            if(optionalUserModel.isPresent()){
                return new ResponseEntity<>(optionalUserModel.get(), HttpStatus.CREATED);
            }else{
                List<String> response = new ArrayList<>();
                response.add("User Not Found");
                return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
            }
        }catch(Exception e){
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
