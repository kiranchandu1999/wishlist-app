package com.driver.service.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.driver.dto.request.WishlistRequest;
import com.driver.dto.response.UserResponse;
import com.driver.dto.response.WishlistResponse;
import com.driver.entity.User;
import com.driver.entity.WishlistItem;
import com.driver.repository.WishlistRepo;
import com.driver.service.UserService;
import com.driver.service.WishlistService;

@Service
public class WishlistServiceImpl implements WishlistService{
    @Autowired
    WishlistRepo wishlistRepo;

    @Autowired
    UserService userService;

    @Autowired
    ModelMapper modelMapper;

    @Override
    public WishlistResponse addWishlistItem(WishlistRequest wishlistRequest, int userId) {
        // converting request dto to entity object to store in db
        WishlistItem newItem = modelMapper.map(wishlistRequest, WishlistItem.class);
        // getting user details
        User user = userService.getUserById(userId);
        // set the user
        newItem.setUser(user);
        // save the item into db
        wishlistRepo.save(newItem);

        WishlistResponse response = modelMapper.map(newItem, WishlistResponse.class);

        response.setUserInfo(modelMapper.map(user, UserResponse.class));

        return response;
    }

    @Override
    public WishlistResponse getWishlistItemById(int itemId, int userId) {
        WishlistItem item = wishlistRepo.findById(itemId).orElseThrow(() -> new RuntimeException("No item exists with this id"));

        // validating that given item belongs to given user or not
        if(item.getUser().getId() == userId){
            return modelMapper.map(item, WishlistResponse.class);
        }
        else{
            throw new RuntimeException("Item not belongs to the current user");
        }
    }

    @Override
    public List<WishlistResponse> getWishlistOfUser(int userId) {
        User user = userService.getUserById(userId);

        List<WishlistResponse> userWishlist = new ArrayList<>();

        for(WishlistItem item : user.getWishlistItems()){
            userWishlist.add(modelMapper.map(item, WishlistResponse.class));
        }

        return userWishlist;
    }

    @Override
    public String deleteWishlistItemById(int itemId, int userId) {
        WishlistItem item = wishlistRepo.findById(itemId).orElseThrow(() -> new RuntimeException("No item exists with this id"));

        // validating that given item belongs to given user or not
        if(item.getUser().getId() == userId){
            return "Wishlist item deleted successfully!!!";
        }
        else{
            throw new RuntimeException("Item not belongs to the current user");
        }
    }
    
}
