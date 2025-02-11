package com.example.finalproject.adapter;

public class MenuItem {
    private int foodImage;
    private String foodName;
    private String foodPrice;

    public MenuItem(int foodImage, String foodName, String foodPrice) {
        this.foodImage = foodImage;
        this.foodName = foodName;
        this.foodPrice = foodPrice;
    }

    public int getFoodImage() {
        return foodImage;
    }

    public String getFoodName() {
        return foodName;
    }

    public String getFoodPrice() {
        return foodPrice;
    }
}
