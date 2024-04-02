package com.driver.service;

import java.util.List;

import com.driver.dto.request.SignupRequest;
import com.driver.dto.response.UserResponse;
import com.driver.entity.User;

public interface UserService {
    public UserResponse addUser(SignupRequest signupRequest);

    public User getUserById(int id);

    public List<UserResponse> getAllUsers();
}
