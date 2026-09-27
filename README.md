# Quiz Application

A backend REST API for a Quiz Application built using Spring Boot, Java, Spring Data JPA, and PostgreSQL.

The application allows users to manage questions, create quizzes based on categories, retrieve quiz questions, and submit answers to calculate their score.

## 🚀 Features

- Add quiz questions
- Retrieve all questions
- Retrieve questions by category
- Create quizzes based on category and number of questions
- Retrieve questions for a specific quiz
- Submit quiz answers
- Calculate quiz score
- PostgreSQL database integration
- RESTful API architecture

## 🛠️ Technologies Used

- Java
- Spring Boot
- Spring Data JPA
- PostgreSQL
- Maven
- REST APIs
- Postman
- Lombok

## 📂 Project Structure

```text
Quiz-Application/
│
├── .mvn/
│   └── wrapper/
│
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── com.example.quizApp/
│   │   │       ├── controller/
│   │   │       ├── model/
│   │   │       ├── repository/
│   │   │       ├── service/
│   │   │       └── QuizAppApplication.java
│   │   │
│   │   └── resources/
│   │       └── application.properties
│   │
│   └── test/
│
├── .gitignore
├── pom.xml
├── mvnw
└── mvnw.cmd
```

---

## 🔗 API Endpoints

### Question APIs

| Method | Endpoint | Description |
|---|---|---|
| GET | `/question/allQuestions` | Get all questions |
| GET | `/question/category/{category}` | Get questions by category |
| POST | `/question/addQuestion` | Add a question |

### Quiz APIs

| Method | Endpoint | Description |
|---|---|---|
| POST | `/quiz/create` | Create a quiz |
| GET | `/quiz/get/{id}` | Get quiz questions |
| POST | `/quiz/submit/{id}` | Submit answers and calculate score |

---

## 🗄️ Database

This project uses **PostgreSQL** with **Spring Data JPA**.

Database credentials are configured using environment variables:

```properties
spring.datasource.url=${DB_URL}
spring.datasource.username=${DB_USERNAME}
spring.datasource.password=${DB_PASSWORD}
```

Hibernate automatically updates the database schema:

```properties
spring.jpa.hibernate.ddl-auto=update
```

The PostgreSQL Hibernate dialect is configured using:

```properties
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.PostgreSQLDialect
```

SQL queries are displayed in the console during development:

```properties
spring.jpa.show-sql=true
```

### Environment Variables

Set the following environment variables before running the application:

```text
DB_URL
DB_USERNAME
DB_PASSWORD
```

---

## ▶️ How to Run

### 1. Clone the repository

```bash
git clone https://github.com/shivanshrastogi12/Quiz-Application.git
```

### 2. Navigate to the project

```bash
cd Quiz-Application
```

### 3. Configure PostgreSQL

Make sure PostgreSQL is installed and running, then configure the required environment variables:

```text
DB_URL
DB_USERNAME
DB_PASSWORD
```

### 4. Run the application

Using Maven:

```bash
mvn spring-boot:run
```

Or run `QuizAppApplication.java` from IntelliJ IDEA.

The application runs on:

```text
http://localhost:8080
```

---

## 🧪 Testing

The REST APIs are tested using **Postman**.

Example:

```text
GET http://localhost:8080/question/allQuestions
```

```text
GET http://localhost:8080/question/category/Java
```

```text
POST http://localhost:8080/question/addQuestion
```

```text
POST http://localhost:8080/quiz/create?category=Java&numQ=5&title=Java%20Quiz
```

```text
GET http://localhost:8080/quiz/get/1
```

```text
POST http://localhost:8080/quiz/submit/1
```

---

## 📌 Project Status

**Backend Completed ✅**

The project currently focuses on backend REST API development and PostgreSQL database integration.

---

## 👨‍💻 Author

**Shivansh Rastogi**

GitHub: https://github.com/shivanshrastogi12

---
