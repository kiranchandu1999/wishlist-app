package com.driver.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.driver.dto.request.WishlistRequest;
import com.driver.dto.response.WishlistResponse;
import com.driver.service.WishlistService;

@RestController
@RequestMapping("/wishlist")
public class WishlistController {
    @Autowired
    WishlistService wishlistService;

    // add wishlist item endpoint
    @PostMapping("/{user_id}")
    public ResponseEntity<WishlistResponse> addWishlistItem(@RequestBody WishlistRequest wishlistRequest, @PathVariable("user_id") int userId){
        WishlistResponse newItemResponse = wishlistService.addWishlistItem(wishlistRequest, userId);

        return new ResponseEntity<>(newItemResponse, HttpStatus.CREATED);
    }

    // Endpoint to get wishlist item by id belongs to current user
    @GetMapping("/{item_id}/user/{user_id}")
    public ResponseEntity<WishlistResponse> getWishlistById(@PathVariable("item_id") int itemId, @PathVariable("user_id") int userId){
        WishlistResponse wishlistResponse = wishlistService.getWishlistItemById(itemId, userId);

        return new ResponseEntity<>(wishlistResponse, HttpStatus.OK);
    }

    // Endpoint to get all items in the wishlist of current user
    @GetMapping("/user/{id}")
    public ResponseEntity<List<WishlistResponse>> getWishlistOfUser(@PathVariable("id") int userId){
        return new ResponseEntity<>(wishlistService.getWishlistOfUser(userId), HttpStatus.OK);
    }

    // Endpoint to delete wishlist item by id which also should be belongs to current user
    @DeleteMapping("/{item_id}/user/{user_id}")
    public ResponseEntity<String> deleteWishlistItemById(@PathVariable("item_id") int itemId, @PathVariable("user_id") int userId){

        return new ResponseEntity<>(wishlistService.deleteWishlistItemById(itemId, userId), HttpStatus.OK);
    }
}
