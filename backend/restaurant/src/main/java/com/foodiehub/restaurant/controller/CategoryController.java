package com.foodiehub.restaurant.controller;

import com.foodiehub.restaurant.model.Category;
import com.foodiehub.restaurant.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/categories")
@CrossOrigin(origins = "*")
public class CategoryController {

    private final CategoryRepository categoryRepository;

    @Value("${upload.dir}")
    private String uploadDir;

    public CategoryController(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    // ✅ ADD CATEGORY
    @PostMapping
    public ResponseEntity<?> addCategory(
            @RequestParam String name,
            @RequestParam MultipartFile image) throws Exception {

        if (categoryRepository.findByNameIgnoreCase(name).isPresent()) {
            return ResponseEntity.badRequest().body("Category already exists");
        }

        String fileName = UUID.randomUUID() + "_" + image.getOriginalFilename();
        Path path = Paths.get(uploadDir + "/categories");

        Files.createDirectories(path);
        image.transferTo(new File(path.toFile(), fileName));

        Category category = new Category();
        category.setName(name);
        category.setImageUrl("categories/" + fileName);

        categoryRepository.save(category);

        return ResponseEntity.ok(category);
    }

    // ✅ GET ALL ACTIVE CATEGORIES
    @GetMapping
    public List<Category> getCategories() {
        return categoryRepository.findByActiveTrue();
    }

    // ✅ DELETE (SOFT DELETE)
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteCategory(@PathVariable Long id) {
        return categoryRepository.findById(id).map(cat -> {
            cat.setActive(false);
            categoryRepository.save(cat);
            return ResponseEntity.ok().build();
        }).orElse(ResponseEntity.notFound().build());
    }

    // ✅ CATEGORY HISTORY (INACTIVE / DELETED)
    @GetMapping("/history")
    public List<Category> getCategoryHistory() {
        return categoryRepository.findByActiveFalse();
    }

    // ✅ RESTORE CATEGORY
    @PutMapping("/{id}/restore")
    public ResponseEntity<?> restoreCategory(@PathVariable Long id) {
        return categoryRepository.findById(id).map(cat -> {
            cat.setActive(true);
            categoryRepository.save(cat);
            return ResponseEntity.ok(cat);
        }).orElse(ResponseEntity.notFound().build());
    }

}
