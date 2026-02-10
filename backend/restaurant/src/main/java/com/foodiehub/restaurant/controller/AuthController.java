package com.foodiehub.restaurant.controller;

import com.foodiehub.restaurant.dto.LoginRequest;
import com.foodiehub.restaurant.dto.RegisterRequest;
import com.foodiehub.restaurant.model.User;
import com.foodiehub.restaurant.service.UserService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin(origins = "*")
public class AuthController {

    private final UserService userService;

    public AuthController(UserService userService) {
        this.userService = userService;
    }

    // ================= REGISTER =================
    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody RegisterRequest request) {

        User user = userService.register(request);

        // ❌ never send password
        user.setPassword(null);

        return ResponseEntity.ok(user);
    }

    // ================= LOGIN (USER + ADMIN) =================
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest request) {

        String email = request.getEmail().trim().toLowerCase();
        String password = request.getPassword().trim();

        // ================= ADMIN LOGIN =================
        if ("admin@foodiehub.com".equals(email) && "admin123".equals(password)) {

            Map<String, Object> adminResponse = new HashMap<>();
            adminResponse.put("id", 0);
            adminResponse.put("name", "Admin");
            adminResponse.put("email", email);
            adminResponse.put("role", "ADMIN");

            return ResponseEntity.ok(adminResponse);
        }

        // ================= USER LOGIN =================
        User user = userService.login(email, password);

        if (user == null) {
            return ResponseEntity
                    .status(HttpStatus.UNAUTHORIZED)
                    .body("Invalid email or password");
        }

        // ❌ never send password
        user.setPassword(null);

        // ✅ FLAT RESPONSE (IMPORTANT)
        Map<String, Object> response = new HashMap<>();
        response.put("id", user.getId());
        response.put("name", user.getName());
        response.put("email", user.getEmail());
        response.put("role", user.getRole().toUpperCase());

        return ResponseEntity.ok(response);
    }

}
