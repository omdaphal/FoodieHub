package com.foodiehub.restaurant.dto;

public class RegisterRequest {

    private String name;
    private String email;
    private String password;

    // ✅ REQUIRED: Proper setter (NO exception)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    // ✅ REQUIRED
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email.trim().toLowerCase();
    }

    // ✅ REQUIRED
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password.trim();
    }
}
