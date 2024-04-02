package com.driver.service;

import java.util.List;

import com.driver.dto.request.WishlistRequest;
import com.driver.dto.response.WishlistResponse;

public interface WishlistService {
    public WishlistResponse addWishlistItem(WishlistRequest wishlistRequest, int userId);

    public WishlistResponse getWishlistItemById(int userId, int itemId);

    public List<WishlistResponse> getWishlistOfUser(int userId);

    public String deleteWishlistItemById(int userId, int itemId);
}
