🍔 FoodieHub – Online Food Ordering System

FoodieHub is a full-stack online food ordering web application that allows users to browse food items, add them to a cart, place orders, and track order status in real time.

The project is built using Spring Boot (Java) for the backend, HTML, CSS, JavaScript for the frontend, and MySQL as the database.

📌 Project Overview

FoodieHub digitizes the food ordering process by providing a clean, user-friendly interface and a scalable backend architecture.

Users can order food seamlessly, while the system efficiently manages carts, orders, payments, and order statuses.

This project demonstrates real-world full-stack development concepts such as:

REST APIs

Database relationships

Order lifecycle management

Payment handling (COD & Online)

Responsive UI design

🚀 Features
👤 User Features

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

🛠 Admin Features

View all customer orders

Update order status (PLACED, ACCEPTED, DELIVERED, CANCELLED)

View payment method & payment status

COD orders marked PAID only after delivery

Online payments auto-marked PAID

Manage food items & categories

⚙️ Backend Features

RESTful APIs using Spring Boot

MySQL database integration

Order lifecycle & payment management

Clean layered architecture

Controller → Service → Repository

Scalable and maintainable backend design

🧱 Technology Stack
🎨 Frontend

HTML5

CSS3

JavaScript (ES6)

Font Awesome Icons

🧠 Backend

Java (17+)

Spring Boot

Spring Data JPA

REST APIs

🗄 Database

MySQL

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
