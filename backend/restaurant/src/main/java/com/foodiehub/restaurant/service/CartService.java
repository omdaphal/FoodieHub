package com.foodiehub.restaurant.service;

import com.foodiehub.restaurant.model.CartItem;
import com.foodiehub.restaurant.repository.CartItemRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartService {

    private final CartItemRepository cartRepository;

    public CartService(CartItemRepository cartRepository) {
        this.cartRepository = cartRepository;
    }

    public CartItem addToCart(CartItem item) {
        return cartRepository.save(item);
    }

    public List<CartItem> getUserCart(Long userId) {
        return cartRepository.findByUserId(userId);
    }

    public void removeItem(Long id) {
        cartRepository.deleteById(id);
    }
}
