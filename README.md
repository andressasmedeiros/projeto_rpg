# Spring Boot API Template

## 📚 Overview

This repository provides a robust template for building RESTful APIs using **Spring Boot**. It includes essential features such as:

- JWT-based authentication and authorization
- PostgreSQL integration
- Flyway for database migrations
- Swagger/OpenAPI for API documentation

---

## 🚀 Getting Started

### 1. Configure Application Properties

Open the `application.properties` file and set the following:

- Database URL, username, and password
- JWT key file paths (`app.key`, `app.pub`)

### 2. Generate JWT Key Files

Generate RSA key pair files for signing and verifying JWTs:

- `app.key`: Private key (keep this secret)
- `app.pub`: Public key

> ⚠️ **Do not commit these files to version control.**

### 3. Run the Application

Start the Spring Boot application using your preferred method:

```bash
./mvnw spring-boot:run
```

---

## 🛠️ Database Configuration

This project uses **PostgreSQL** and **Flyway** for managing schema migrations.

### Flyway Installation

#### On Linux/macOS:

```bash
sudo snap install flyway
```

#### On Windows:

Download and install from the [Flyway official site](https://flywaydb.org/download/).

### Running Migrations

Use the following command to apply migrations:

```bash
flyway -url=jdbc:postgresql://localhost:5432/spring_base \
       -user=postgres \
       -password=postgres \
       -schemas=base \
       -locations=filesystem:./flyway/db \
       migrate
```

---

## 📖 API Documentation

Swagger UI is enabled for exploring and testing endpoints.

- 🔗 [Swagger UI](https://localhost:8443/swagger-ui/index.html)

The interface allows you to authenticate using your JWT token and interact with secured endpoints directly.

---

## 🙌 Contribution

Feel free to fork this repository and adapt it to your own project. PRs are welcome if you find improvements or bug fixes to share!

---

## 📄 License

This project is open-source and available under the MIT License.
