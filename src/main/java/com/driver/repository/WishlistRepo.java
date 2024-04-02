package com.driver.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.driver.entity.WishlistItem;

@Repository
public interface WishlistRepo extends JpaRepository<WishlistItem, Integer>{
    
}
