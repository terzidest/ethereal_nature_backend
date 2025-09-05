
# Ethereal Nature Backend 🌿

A **Spring Boot backend** for **Ethereal Nature**, a demo e-commerce mobile app built with React Native.  
This backend provides secure APIs for user authentication, product management, and order handling.

---

## 🚀 Features

- **User Authentication**
    - JWT-based login & registration
    - Role-based access (user, admin)

- **Product Management**
    - Create, read, update, and delete products
    - Categories and product details

- **Order Management**
    - Place and manage orders
    - Retrieve order history per user

- **Database Persistence**
    - Powered by relational database (e.g., PostgreSQL/MySQL/H2 for dev)
    - Entities: Users, Products, Orders

---

## 🛠️ Tech Stack

- **Java 17+**
- **Spring Boot 3**
    - Spring Web (REST API)
    - Spring Security (JWT)
    - Spring Data JPA
- **Database**: PostgreSQL (prod)
- **Build Tool**: Gradle

---

## 📂 Project Structure

```
ethereal_nature_backend/
 ├── AppApplication.java              # Main Spring Boot entry point
 │
 ├── config/                          # Global config & security
 │   ├── SecurityConfig.java
 │   ├── JwtFilter.java
 │   └── WebConfig.java (CORS, etc.)
 │
 ├── auth/                            # Authentication & JWT
 │   ├── AuthController.java
 │   ├── AuthService.java
 │   ├── JwtService.java
 │   ├── AuthRequest.java
 │   └── AuthResponse.java
 │
 ├── user/                            # Users & roles
 │   ├── User.java
 │   ├── UserRepository.java
 │   ├── UserService.java
 │   └── UserController.java
 │
 ├── product/                         # Products & categories
 │   ├── Product.java
 │   ├── Category.java
 │   ├── ProductRepository.java
 │   ├── ProductService.java
 │   └── ProductController.java
 │
 ├── order/                           # Orders & order items
 │   ├── Order.java
 │   ├── OrderItem.java
 │   ├── OrderRepository.java
 │   ├── OrderService.java
 │   └── OrderController.java
 │
 └── profile/                         # User profile details
     ├── Profile.java
     ├── ProfileRepository.java
     ├── ProfileService.java
     └── ProfileController.java
```

---

## ⚡ Getting Started

### Prerequisites
- Java 17+
- Maven 3+
- (Optional) PostgreSQL/MySQL if not using H2

### Run locally
```bash
# Clone repo
git clone https://github.com/terzidest/ethereal_nature_backend.git
cd ethereal_nature_backend

# Build & run
mvn spring-boot:run
```

Backend will start at: http://localhost:8080

---
```
🔑 API Endpoints (Sample)
Auth
POST /api/auth/register – create new user
POST /api/auth/login – authenticate user and get JWT
Products
GET /api/products – list all products
POST /api/products – create new product (admin only)
Orders
POST /api/orders – place a new order
GET /api/orders/user/{id} – get user’s order history
```
📱 Frontend Integration
The backend is designed to integrate with the [Ethereal Nature React Native frontend](https://github.com/terzidest/ethereal_nature).

