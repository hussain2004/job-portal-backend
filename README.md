# Job Portal Backend

A Spring Boot backend application for a Job Portal system that provides secure user registration, login, and user management using JWT Authentication and Spring Security.

## Features

### User Management
- User Registration
- User Login
- User CRUD Operations
- DTO-based API Responses
- Input Validation
- Global Exception Handling

### Security
- BCrypt Password Encryption
- JWT Token Generation
- JWT Token Validation Support
- Spring Security Integration

### Database
- MySQL Integration
- Spring Data JPA
- Repository Pattern

## Tech Stack

| Technology | Version |
|------------|----------|
| Java | 17 |
| Spring Boot | 3.x |
| Spring Security | Latest |
| Spring Data JPA | Latest |
| MySQL | 8 |
| Maven | Latest |
| JWT | 0.11.5 |

## Project Structure

```text
src/main/java
├── config
├── controller
├── dto
├── entity
├── exception
├── repository
└── service
```

## API Endpoints

### Authentication

| Method | Endpoint |
|----------|----------|
| POST | /users/register |
| POST | /users/login |

### User Management

| Method | Endpoint |
|----------|----------|
| GET | /users |
| GET | /users/{id} |
| PUT | /users/{id} |
| DELETE | /users/{id} |

## Sample Login Response

```json
{
  "token": "eyJhbGciOiJIUzI1NiJ9..."
}
```

## Current Progress

Completed:
- User Module
- Authentication Module
- JWT Generation
- BCrypt Encryption
- DTO Pattern
- Validation
- Exception Handling
- GitHub Integration

In Progress:
- JWT Authorization Filter
- Protected APIs
- Role-Based Access Control

Upcoming Features:
- Job Management Module
- Job Application Module
- Recruiter Dashboard
- Admin Dashboard
- Swagger API Documentation
- Docker Support
- Cloud Deployment

## Author

Shaik Mahaboob Hussain

Final Year Computer Science Engineering Student
