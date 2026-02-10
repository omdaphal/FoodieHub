package com.foodiehub.restaurant.controller;

import com.foodiehub.restaurant.dto.RegisterRequest;
import com.foodiehub.restaurant.model.User;
import com.foodiehub.restaurant.service.UserService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
@CrossOrigin("*")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    // ✅ REGISTER API
    @PostMapping("/register")
    public User register(@RequestBody RegisterRequest request) {
        return userService.register(request);
    }

    // ✅ LOGIN API
    @PostMapping("/login")
    public User login(@RequestBody User user) {
        return userService.login(user.getEmail(), user.getPassword());
    }
}
