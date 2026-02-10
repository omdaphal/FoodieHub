# 🍔 FoodieHub – Online Food Ordering System

FoodieHub is a full-stack web application that allows users to browse food items, manage carts, place orders, and track order history.
The project is built using Spring Boot for the backend and HTML, CSS, JavaScript for the frontend, following a clean MVC architecture.

This project demonstrates real-world concepts like REST APIs, database integration, authentication, and frontend-backend communication.

# 📌 Project Overview

Project Name: FoodieHub
Project Type: Full Stack Web Application
Architecture: MVC (Model–View–Controller)
Backend: Spring Boot (Java)
Frontend: HTML, CSS, JavaScript
Database: MySQL
API Communication: REST APIs (JSON)

# ✨ Features
## 👤 User Features
User Registration & Login
View food menu with categories
Add / remove items from cart
Update item quantity in cart
Place food orders
View order history
Responsive UI for mobile and desktop

## 🛠️ Admin / System Features
Manage food items (Add / View)
Handle cart operations
Process and store orders
Secure backend APIs
Centralized exception handling

# 🧩 Modules
## 🔐 Authentication Module
User registration
User login validation
Secure API access

## 🍽️ Food Module
Fetch food items from database
Display menu dynamically
Category-based filtering

## 🛒 Cart Module
Add items to cart
Remove items from cart
Update quantity
Calculate total price

## 📦 Order Module
Place order from cart
Save order and order items
Fetch user-specific order history

## 🏗 Folder Structure – FoodieHub
```text
FoodieHub/
├── foodiehub-backend/          # Spring Boot Backend
│   ├── src/main/java/com/foodiehub/restaurant/
│   │   ├── controller/
│   │   ├── service/
│   │   ├── repository/
│   │   ├── model/
│   │   └── FoodieHubApplication.java
│   │
│   └── src/main/resources/
│       ├── application.properties
│       └── static/
│
├── foodiehub-frontend/         # Frontend
│   ├── index.html
│   ├── login.html
│   ├── register.html
│   ├── menu.html
│   ├── cart.html
│   ├── checkout.html
│   ├── orders.html
│   ├── dashboard.html
│   ├── contact.html
│   ├── css/
│   │   └── style.css
│   └── js/
│       └── main.js
│
└── README.md

## ⚙️ Technology Stack
Backend

Java

Spring Boot

Spring MVC

Spring Data JPA

RESTful APIs
