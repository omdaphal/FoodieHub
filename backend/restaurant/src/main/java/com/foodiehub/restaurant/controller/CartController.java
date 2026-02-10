package com.foodiehub.restaurant.controller;

import com.foodiehub.restaurant.model.CartItem;
import com.foodiehub.restaurant.service.CartService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cart")
@CrossOrigin("*")
public class CartController {

    private final CartService cartService;

    public CartController(CartService cartService) {
        this.cartService = cartService;
    }

    // Add to cart
    @PostMapping
    public CartItem addToCart(@RequestBody CartItem item) {
        return cartService.addToCart(item);
    }

    // View cart by user
    @GetMapping("/{userId}")
    public List<CartItem> getCart(@PathVariable Long userId) {
        return cartService.getUserCart(userId);
    }

    // Remove item
    @DeleteMapping("/{id}")
    public void removeItem(@PathVariable Long id) {
        cartService.removeItem(id);
    }
}
