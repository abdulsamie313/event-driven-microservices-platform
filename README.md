# Event Driven Microservices Platform

A scalable event-driven microservices platform built using Spring Boot, Apache Kafka, PostgreSQL, Docker, and Angular.

## 🚀 Tech Stack

### Backend
- Java 17
- Spring Boot 3
- Spring Security + JWT
- Spring Data JPA
- Apache Kafka
- PostgreSQL

### Frontend
- Angular

### DevOps & Infrastructure
- Docker
- Docker Compose
- Kubernetes
- Jenkins CI/CD

---

# 🏗️ Architecture

The platform follows an event-driven microservices architecture.

## Services

### User Service
Responsible for:
- User registration
- Authentication
- Publishing Kafka events

### Notification Service
Consumes `user-created` Kafka events and processes notifications.

### Analytics Service
Consumes Kafka events for analytics and monitoring purposes.

---

# 🔄 Event Flow

1. User registers through API
2. User Service saves user in PostgreSQL
3. User Service publishes `user-created` event to Kafka
4. Notification Service consumes event
5. Analytics Service consumes event

---

# 🐳 Docker Compose

The project uses Docker Compose to orchestrate:

- PostgreSQL
- Kafka
- Zookeeper
- User Service

Run project:

```bash
docker compose up -d
```

---

# Security

Implemented:
- JWT Authentication
- Stateless session management
- Spring Security filters
- Protected APIs

---

# Kafka Features

Implemented:
- Kafka Producer
- Multiple Kafka Consumers
- Consumer Groups
- Retry Handling
- Dead Letter Topic (DLT)

---

# Database

PostgreSQL is used as the primary database.

Features:
- JPA/Hibernate
- Entity relationships
- Unique constraints
- Profile-based configuration

---

# Frontend

Angular frontend includes:
- User creation UI
- Notifications page
- Analytics page
- Navbar routing

---

# Profiles

## Development Profile
Used for local development.

## Deployment Profile
Used for Docker deployment.

---

# Kubernetes

Implemented:
- Deployment
- Services
- Ingress
- Multi-pod deployment

---

# CI/CD

Basic Jenkins pipeline implemented for:
- Build
- Test
- Docker build

---

# Concepts Demonstrated

- Microservices Architecture
- Event-Driven Design
- Asynchronous Communication
- Kafka Messaging
- Dockerization
- Container Orchestration
- Secure REST APIs
- Distributed Systems Basics

---

#  Author

Abdul Samie

Software Engineer | Backend Systems | Microservices | AI Enthusiast