package com.driver.dto.response;

public class WishlistResponse {
    private int id;

    private String name;

    private String description;

    private double price;

    private UserResponse userInfo;

    public WishlistResponse() {
    }

    public WishlistResponse(int id, String name, String description, double price, UserResponse userInfo) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.userInfo = userInfo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public UserResponse getUserInfo() {
        return userInfo;
    }

    public void setUserInfo(UserResponse userInfo) {
        this.userInfo = userInfo;
    }
}
