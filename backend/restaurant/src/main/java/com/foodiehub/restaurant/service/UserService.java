package com.foodiehub.restaurant.service;

import com.foodiehub.restaurant.dto.RegisterRequest;
import com.foodiehub.restaurant.model.User;
import com.foodiehub.restaurant.repository.UserRepository;

import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    // ================= REGISTER =================
    public User register(RegisterRequest request) {

        String email = request.getEmail().trim().toLowerCase();

        userRepository.findByEmailIgnoreCase(email)
            .ifPresent(u -> {
                throw new RuntimeException("Email already exists");
            });

        User user = new User();
        user.setName(request.getName());
        user.setEmail(email);
        user.setPassword(request.getPassword()); // plain (for now)
        user.setRole("USER");

        return userRepository.save(user);
    }

    // ================= LOGIN =================
    public User login(String email, String password) {

        return userRepository.findByEmailIgnoreCase(email.trim())
            .filter(u -> u.getPassword().equals(password))
            .orElse(null);
    }
}
