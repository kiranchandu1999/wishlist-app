package com.driver.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.driver.dto.request.SignupRequest;
import com.driver.dto.response.UserResponse;
import com.driver.service.UserService;

@RestController
@RequestMapping("/auth")
public class UserController {
    @Autowired
    UserService userService;

    // Endpoint to add new user / signup
    @PostMapping("/signup")
    public ResponseEntity<UserResponse> addUser(@RequestBody SignupRequest signupRequest){
        UserResponse newUser = userService.addUser(signupRequest);

        return new ResponseEntity<>(newUser, HttpStatus.CREATED);
    }

    // Endpoint to get all users
    @GetMapping
    public ResponseEntity<List<UserResponse>> getUsers(){
        return new ResponseEntity<>(userService.getAllUsers(), HttpStatus.OK);
    }
}
