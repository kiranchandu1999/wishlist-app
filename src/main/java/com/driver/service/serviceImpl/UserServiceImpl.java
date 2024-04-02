package com.driver.service.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.driver.dto.request.SignupRequest;
import com.driver.dto.response.UserResponse;
import com.driver.entity.User;
import com.driver.repository.UserRepo;
import com.driver.service.UserService;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserRepo userRepo;

    @Autowired
    ModelMapper modelMapper;

    @Override
    public UserResponse addUser(SignupRequest signupRequest) {
        User newUser = modelMapper.map(signupRequest, User.class);

        userRepo.save(newUser);

        return modelMapper.map(newUser, UserResponse.class);
    }

    @Override
    public User getUserById(int id) {
        User user = userRepo.findById(id).orElseThrow(() -> new RuntimeException("User not found"));

        return user;
    }

    @Override
    public List<UserResponse> getAllUsers() {
        List<User> users = userRepo.findAll();

        List<UserResponse> userResponses = new ArrayList<>();

        for(User u : users){
            userResponses.add(modelMapper.map(u, UserResponse.class));
        }

        return userResponses;
    }
    
}
