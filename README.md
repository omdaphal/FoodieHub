# 🐾 Pet Adoption Web Application

## 📌 Project Overview
The **Pet Adoption Web Application** is a full-stack web platform developed using **Flask (Python)** and **SQLite**, designed to simplify and digitalize the pet adoption process.

It provides a secure and user-friendly system where users can browse pets, send adoption requests, and submit reviews, while administrators manage pets and approve or reject adoption requests.

This project demonstrates real-world web development concepts such as authentication, role-based access control, database management, pagination, and responsive UI design.

## 🎯 Objectives
- Provide a centralized platform for pet adoption
- Reduce manual communication and paperwork
- Implement secure user authentication
- Enable admins to control and monitor adoption activities
- Practice real-world full-stack development concepts

## 👥 User Roles

### 👤 User
- Register and log in securely
- Browse available pets
- View pet details (age, location, health, price)
- Submit adoption requests
- Track request status (Pending / Approved / Rejected)
- Submit reviews and ratings
- Access personal dashboard

### 🛠️ Admin
- Secure admin login
- View and manage all pet listings
- Approve or reject adoption requests
- Delete pets from the system
- View user reviews
- Monitor dashboard statistics

## 🔐 Authentication & Security
- Password hashing for secure storage
- Session-based authentication
- CSRF protection for all forms
- Role-based route protection
- Input validation and secure form handling

## 🗃️ Database Design (SQLite)

### Tables Used
- **users** – Stores user and admin accounts
- **pets** – Stores pet details and availability
- **adoption_requests** – Tracks adoption requests and status
- **reviews** – Stores user ratings and feedback
- **notifications** – Stores system actions (optional)

### Database Features
- Auto-increment primary keys
- Foreign key relationships
- Status-based workflow
- Timestamp tracking

## 🔁 Adoption Workflow
1. User browses pets
2. User submits an adoption request
3. Request status is set to **Pending**
4. Admin reviews the request
5. Admin approves or rejects the request
6. Updated status is reflected on the user dashboard

## 🧩 Core Modules

### 📋 Dashboard
- Displays user greeting and statistics
- Admin dashboard shows analytics and counts

### 🐶 Pet Management
- Card-based pet listings
- Price badge (Free / Paid)
- Status-based filtering

### ⭐ Review System
- Star rating system (0–5)
- Review submission with timestamp
- Average rating calculation
- Admin moderation support

### 📄 Pagination & Filtering
- Pagination for pets and reviews
- Tab-based filtering (Pending / Approved / Rejected)
- Optimized for performance

## 🎨 Frontend Design
- Responsive UI using Bootstrap
- Mobile-friendly layout
- Clean card-based design
- Modal-based actions
- Toast notifications and alerts

## 🧰 Technology Stack

### Backend
- Python
- Flask Framework
- SQLite Database

### Frontend
- HTML5
- CSS3
- Bootstrap
- JavaScript (Vanilla)

### Tools
- Git & GitHub
- VS Code
- Flask-WTF (CSRF Protection)
- Werkzeug (Password Hashing)

## 📁 Project Structure

```text
PET_ADOPTION/
├── app.py                      # Main Flask application
├── config.py                   # Application configuration
├── requirements.txt            # Python dependencies
├── README.md                   # Project documentation
│
├── instance/
│   └── pet_adoption.db         # SQLite database
│
├── static/
│   ├── css/
│   │   ├── style.css
│   │   └── responsive.css
│   ├── js/
│   │   └── app.js
│   └── uploads/                # Uploaded pet images
│
├── templates/
│   ├── base.html
│   ├── index.html
│   ├── dashboard.html
│   │
│   ├── auth/
│   │   ├── login.html
│   │   └── register.html
│   │
│   ├── admin/
│   │   ├── admin.html
│   │   ├── edit_pet.html
│   │   └── notifications.html
│   │
│   ├── pets/
│   │   ├── pet_detail.html
│   │   └── _pet_card.html
│
├── scripts/
│   ├── clear_all_activity.py
│   ├── clear_users.py
│   ├── reset_sqlite_sequence.py
│   └── reviews.py
│
├── database/
│   └── schema.sql
│
├── .gitignore
└── venv/
```
<h2>Create Virtual Environment</h2>
python -m venv venv
venv\Scripts\activate

<h2>Install Dependencies</h2>
pip install -r requirements.txt

<h2>Run Application</h2>
python app.py

<h2>Open in browser:</h2>
http://127.0.0.1:5000

## 📈 Learning Outcomes
- Flask routing and template rendering
- Secure authentication and session handling
- SQL database design and CRUD operations
- Pagination and filtering logic
- Admin and user role separation
- Real-world workflow implementation

## 🚀 Future Enhancements
- Email notifications
- Image upload optimization
- Advanced search and filtering
- REST API integration
- OAuth login (Google, Facebook)
- Cloud deployment

## 👨‍💻 Author
OM Daphal
Web Development & Python Enthusiast
