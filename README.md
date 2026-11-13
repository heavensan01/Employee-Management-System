# Employee Management System

Java Full Stack web application built with **Spring Boot, Thymeleaf, Spring Data JPA, Spring Security and H2**.

**Live demo:** https://YOUR-APP-NAME.onrender.com  
_(free hosting sleeps when idle, so the first load can take up to a minute)_

## Features
- Admin / Employee login (Spring Security, BCrypt passwords)
- Employee CRUD
- Attendance management
- Payroll calculation
- Department and designation management
- Dashboard with Chart.js

## Tech stack
Java 17, Spring Boot 3.5, Spring MVC, Thymeleaf, Spring Data JPA (Hibernate), Spring Security, H2, Maven, Docker

## Demo login
| Role | Email | Password |
|------|-------|----------|
| Admin | admin@example.com | admin123 |
| Employee | employee@example.com | employee123 |

These are seeded demo accounts only (see `DataInitializer`).

## Run locally
Requirements: JDK 17+ and Maven 3.9+.

```bash
mvn spring-boot:run
```

Open http://localhost:8080

To enable the H2 console locally (disabled by default):

```bash
mvn spring-boot:run -Dspring-boot.run.arguments=--spring.h2.console.enabled=true
```
Then open http://localhost:8080/h2-console with JDBC URL `jdbc:h2:file:./data/employee_management`, user `sa`, empty password.

## Run with Docker
```bash
docker build -t ems .
docker run -p 8080:8080 ems
```

## Deploy (Render)
1. Push this repo to GitHub.
2. On render.com choose **New > Web Service**, select the repo.
3. Set the runtime to **Docker**, pick the free instance, and deploy.

Note: the H2 database lives inside the container, so data resets on every redeploy or restart. Demo users and sample data are re-created automatically on startup.

## Project structure
```
src/main/java/com/example/ems
  config/       DataInitializer (seed data)
  controller/   Auth, Dashboard, Employee, Department, Designation, Attendance, Payroll
  entity/       JPA entities
  repository/   Spring Data repositories
  security/     SecurityConfig, CustomUserDetailsService
src/main/resources
  templates/    Thymeleaf pages
  static/css/   Styles
```
