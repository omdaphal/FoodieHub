# 🍔 FoodieHub – Online Food Ordering System

FoodieHub is a full-stack online food ordering web application that allows users to browse food items, add them to a cart, place orders, and track order status in real time.

The project is built using Spring Boot (Java) for the backend, HTML, CSS, JavaScript for the frontend, and MySQL as the database.

## 📌 Project Overview

FoodieHub digitizes the food ordering process by providing a clean, user-friendly interface and a scalable backend architecture.

Users can order food seamlessly, while the system efficiently manages carts, orders, payments, and order statuses.

This project demonstrates real-world full-stack development concepts such as:
 REST APIs
 Database relationships
 Order lifecycle management
 Payment handling (COD & Online)
 Responsive UI design

## 🚀 Features
# 👤 User Features

User registration & login
Browse food menu
Add food items to cart (database-based cart)
View & manage cart items
Place food orders
Multiple payment options (COD / UPI / Card / Net Banking)
View order history
Cancel orders (only when status is PLACED)
Real-time order status updates
Fully responsive UI (Desktop & Mobile)

## 🛠 Admin Features

View all customer orders
Update order status (PLACED, ACCEPTED, DELIVERED, CANCELLED)
View payment method & payment status
COD orders marked PAID only after delivery
Online payments auto-marked PAID
Manage food items & categories

## ⚙️ Backend Features

RESTful APIs using Spring Boot
MySQL database integration
Order lifecycle & payment management
Clean layered architecture
Controller → Service → Repository
Scalable and maintainable backend design

## 🧱 Tech Stack
## Frontend

HTML5
CSS3
JavaScript (ES6)
Font Awesome Icons

## Backend

Java (17+)
Spring Boot
Spring Data JPA
REST APIs

## Database
MySQL

## FoodieHub Folder Structure /
│
├── foodiehub-backend/                  # Spring Boot Backend
│   ├── src/main/java/com/foodiehub/restaurant/
│   │   ├── controller/
│   │   │   ├── AuthController.java
│   │   │   ├── CartController.java
│   │   │   ├── OrderController.java
│   │   │   └── FoodController.java
│   │   │
│   │   ├── service/
│   │   │   ├── UserService.java
│   │   │   ├── CartService.java
│   │   │   └── OrderService.java
│   │   │
│   │   ├── repository/
│   │   │   ├── UserRepository.java
│   │   │   ├── FoodRepository.java
│   │   │   ├── CartItemRepository.java
│   │   │   └── OrderRepository.java
│   │   │
│   │   ├── model/
│   │   │   ├── User.java
│   │   │   ├── Food.java
│   │   │   ├── CartItem.java
│   │   │   ├── Order.java
│   │   │   └── OrderItem.java
│   │   │
│   │   └── FoodieHubApplication.java
│   │
│   └── src/main/resources/
│       ├── application.properties
│       └── static/
│
├── foodiehub-frontend/                 # Frontend (HTML, CSS, JS)
│   ├── index.html
│   ├── login.html
│   ├── register.html
│   ├── menu.html
│   ├── cart.html
│   ├── checkout.html
│   ├── orders.html
│   ├── dashboard.html
│   ├── contact.html
│   │
│   ├── css/
│   │   └── style.css
│   │
│   └── js/
│       └── main.js

## 🗄 Database Tables

users
food
categories
category_history
cart_items
orders
order_items
notifications

## ⚙️ Setup & Installation
1️⃣ Create MySQL Database
CREATE DATABASE foodiehub_db;

## 2️⃣ Configure Backend

Edit application.properties:
spring.datasource.url=jdbc:mysql://localhost:3302/foodiehub_db
spring.datasource.username=root
spring.datasource.password=your_password

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true

server.port=8090

## 3️⃣ Run Backend
mvn spring-boot:run


## Backend will start at:

http://localhost:8090

## 4️⃣ Run Frontend

Open the frontend folder in VS Code
Use Live Server
Or open .html files directly in the browser

## 🔗 Important API Endpoints
🛒 Cart APIs
POST   /api/cart                 → Add item to cart
GET    /api/cart/{userId}        → Get user cart
DELETE /api/cart/{cartItemId}    → Remove item from cart

## 📦 Order APIs
POST /api/orders/place                  → Place order
GET  /api/orders/user/{userId}          → Get user orders
PUT  /api/orders/{orderId}/cancel       → Cancel order
PUT  /api/orders/{orderId}/status       → Update order status (Admin)
PUT  /api/orders/{orderId}/payment-status → Update payment status (Admin)

## 💳 Payment Logic

COD (Cash on Delivery)
Initial status: PENDING
Becomes PAID after delivery
UPI / Card / Net Banking
Automatically marked PAID after successful payment
Admin can only view payment status (read-only)

## 🚀 Future Enhancements

Real payment gateway integration (Razorpay / Stripe)
JWT-based authentication & authorization
Email / SMS notifications
Admin analytics dashboard
Cloud deployment (AWS / Render / Railway)

## 👨‍💻 Designed & Developed By

Om Daphal
Java Full Stack Developer
Building clean, scalable & real-world web applications 🚀
