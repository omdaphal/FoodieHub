package com.foodiehub.restaurant.repository;

import com.foodiehub.restaurant.model.Food;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FoodRepository extends JpaRepository<Food, Long> {

    // 🔍 Find food by category name (case-insensitive)
    List<Food> findByCategory_NameIgnoreCase(String name);
}
