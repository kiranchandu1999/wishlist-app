package com.driver.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.driver.entity.User;

public interface UserRepo extends JpaRepository<User, Integer>{
    
}
