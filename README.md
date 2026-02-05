# Product Management Application

A simple full-stack Product Management application built with **Spring Boot** and a **HTML/CSS/JavaScript frontend**.  
The application demonstrates complete **CRUD operations**, backend **validation**, and a minimal frontend that consumes REST APIs.

**Tech Stack**
- Backend: Java, Spring Boot, Spring Web, Jakarta Bean Validation, Lombok  
- Frontend: HTML, CSS, JavaScript (Fetch API)  
- The frontend is served directly from Spring Boot using static resources.

**How to Run the Application**
- Prerequisites: Java 17+ and Maven  
- Steps:
  ```bash
  git clone https://github.com/DakhinTudu/e-commerce-simple-crud-sprringboot-application.git
  cd <project-folder>
  mvn spring-boot:run

  Open in browser:
  http://localhost:8080
  
  ```
**API Endpoints**
- POST /api/product – Create a new product
- GET /api/product – Fetch all products
- GET /api/product/{id} – Fetch product by ID
- PUT /api/product/{id} – Update an existing product
- DELETE /api/product/{id} – Delete a product

**Validation**
- productName and description are required
- productPrice must be greater than 0
- quantity cannot be negative
- Validation errors are returned as field-specific messages and displayed on the frontend.

**Implementation Details**
- Uses an in-memory data store (ArrayList) for simplicity
- Thread-safe ID generation using AtomicLong
- Consistent API responses using a generic ApiResponse<T> wrapper
- Backend and frontend are hosted in the same Spring Boot application to avoid CORS issues

  
