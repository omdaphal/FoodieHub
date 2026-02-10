package com.foodiehub.restaurant.controller;

import com.foodiehub.restaurant.model.Category;
import com.foodiehub.restaurant.model.Food;
import com.foodiehub.restaurant.model.FoodType;
import com.foodiehub.restaurant.repository.CategoryRepository;
import com.foodiehub.restaurant.repository.FoodRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/food")
@CrossOrigin("*")
public class FoodController {

    private final FoodRepository foodRepository;
    private final CategoryRepository categoryRepository;

    @Value("${upload.dir}")
    private String uploadDir;

    public FoodController(FoodRepository foodRepository,
                          CategoryRepository categoryRepository) {
        this.foodRepository = foodRepository;
        this.categoryRepository = categoryRepository;
    }

    // ================= GET ALL FOOD =================
    @GetMapping
    public List<Food> getAllFood() {
        return foodRepository.findAll();
    }

    // ================= GET BY CATEGORY =================
    @GetMapping("/category/{categoryName}")
    public List<Food> getByCategory(@PathVariable String categoryName) {
        return foodRepository.findByCategory_NameIgnoreCase(categoryName);
    }

    // ================= ADD FOOD (ADMIN ONLY) =================
    @PostMapping
    public Food addFood(
            @RequestParam String name,
            @RequestParam String description,
            @RequestParam double price,
            @RequestParam double rating,
            @RequestParam String foodType,
            @RequestParam Long categoryId,
            @RequestParam("image") MultipartFile image
    ) throws IOException {

        // ⭐ Rating validation
        if (rating < 0 || rating > 5) {
            throw new RuntimeException("Rating must be between 0 and 5");
        }

        // 🟢 VEG / 🔴 NON_VEG validation
        if (!foodType.equalsIgnoreCase("VEG") &&
            !foodType.equalsIgnoreCase("NON_VEG")) {
            throw new RuntimeException("Food type must be VEG or NON_VEG");
        }

        Category category = categoryRepository.findById(categoryId)
                .orElseThrow(() -> new RuntimeException("Category not found"));

        // 📁 uploads/foods
        Path foodDir = Paths.get(uploadDir, "foods");
        Files.createDirectories(foodDir);

        String fileName = UUID.randomUUID() + "_" + image.getOriginalFilename();
        image.transferTo(new File(foodDir.toFile(), fileName));

        Food food = new Food();
        food.setName(name);
        food.setDescription(description);
        food.setPrice(price);
        food.setRating(rating);

        // ✅ STRING → ENUM (FIXED ERROR)
        food.setFoodType(FoodType.valueOf(foodType.toUpperCase()));

        food.setCategory(category);
        food.setImageUrl("foods/" + fileName);

        return foodRepository.save(food);
    }

    // ================= DELETE FOOD (ADMIN) =================
    @DeleteMapping("/{id}")
    public void deleteFood(@PathVariable Long id) {
        foodRepository.deleteById(id);
    }
}
