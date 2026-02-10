package com.foodiehub.restaurant.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public class CartItemDTO {

    @NotNull(message = "FoodId is required")
    private Long foodId;

    @NotNull(message = "Food name is required")
    private String name;

    @Positive(message = "Price must be greater than 0")
    private double price;

    @Positive(message = "Quantity must be at least 1")
    private int qty;

    // ===== GETTERS & SETTERS =====

    public Long getFoodId() {
        return foodId;
    }

    public void setFoodId(Long foodId) {
        this.foodId = foodId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }
}
