# Delivery Service Application

## Overview

This project is a Spring Boot application for managing delivery time slots. It supports different delivery methods and allows users to book available time slots. The application uses different database configurations for development (MySQL) and production (PostgreSQL) environments.

## Project Structure

- **DTOs (Data Transfer Objects)**:
    - `TimeSlotDTO`: Represents the time slot data.
    - `BookingRequestDTO`: Handles booking requests.

- **Mappers**:
    - `TimeSlotMapper`: Maps between `TimeSlot` entities and `TimeSlotDTO` using MapStruct.

- **Controllers**:
    - `DeliveryController`: REST controller that exposes endpoints for fetching available time slots and booking a time slot.

- **Services**:
    - `DeliveryService`: Contains the business logic for fetching and booking time slots.

- **Models**:
    - `DeliveryMethod`: Enum representing different delivery methods.
    - `TimeSlot`: Entity representing a delivery time slot.

- **Repositories**:
    - `TimeSlotRepository`: JPA repository for `TimeSlot` entities.

- **Configuration Files**:
    - `application.properties`: Sets the active profile.
    - `application-dev.properties`: Configuration for the development environment using MySQL.
    - `application-prod.properties`: Configuration for the production environment using PostgreSQL.

## Requirements

- Java 11 or later
- MySQL (for development)
- PostgreSQL (for production)
- Gradle

## Setup

### 1. Clone the repository

```bash
git clone <repository-url>
cd <repository-directory>
```

### 2. Build the project
Use Gradle to build the project.

```bash
./gradlew clean build
```

### 3. Run the application
## 1. Development
```bash
./gradlew bootRun
```
## 2. Production
```bash
./gradlew bootRun --args='--spring.profiles.active=prod'
```

### 4. Deployment

## 1. Development
```bash
docker-compose -f docker-compose.yml -f docker-compose.dev.yml up
```
## 2. Production
```bash
docker-compose -f docker-compose.yml -f docker-compose.prod.yml up
```