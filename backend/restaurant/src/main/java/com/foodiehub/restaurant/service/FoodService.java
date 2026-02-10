package com.foodiehub.restaurant.service;

import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class FoodService {

    public List<String> getFoods() {
        return List.of("Pizza", "Burger", "Pasta");
    }
}
