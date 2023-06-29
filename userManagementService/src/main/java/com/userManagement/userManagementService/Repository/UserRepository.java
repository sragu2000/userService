package com.userManagement.userManagementService.Repository;

import com.userManagement.userManagementService.Model.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<UserModel, Long> {
    List<UserModel> findByEmail(String email);
}