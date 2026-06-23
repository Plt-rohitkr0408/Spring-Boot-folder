# Library Management System

A RESTful Library Management System built using Spring Boot, Spring Data JPA, Hibernate, and MySQL. This application allows administrators to manage books and students, issue and return books, and automatically calculate fines for late returns.

## Features

### Book Management

* Add new books
* View all books
* Get book details by ID
* Update book information
* Delete books

### Student Management

* Register new students
* View all students
* Get student details by ID
* Update student information
* Delete students

### Book Issue & Return

* Issue books to students
* Return issued books
* Automatically update available book quantity
* Track issue date, due date, and return date

### Fine Management

* Calculate fines for overdue books
* Store fine amount with issue records

### Exception Handling

* Global exception handling using `@RestControllerAdvice`
* Custom exception responses with timestamp and message

---

## Tech Stack

* Java 17+
* Spring Boot
* Spring Data JPA
* Hibernate
* MySQL
* Maven
* Postman

---

## Database Schema

### Student Table

| Column   | Type    |
| -------- | ------- |
| std_id   | INT     |
| std_name | VARCHAR |
| email    | VARCHAR |
| phone_no | VARCHAR |

### Book Table

| Column       | Type    |
| ------------ | ------- |
| book_id      | INT     |
| book_title   | VARCHAR |
| book_edition | VARCHAR |
| author       | VARCHAR |
| qty          | INT     |
| category     | VARCHAR |

### IssueBook Table

| Column      | Type     |
| ----------- | -------- |
| issue_id    | INT      |
| issue_date  | DATETIME |
| due_date    | DATETIME |
| return_date | DATETIME |
| fine_amount | DOUBLE   |
| book_id     | INT (FK) |
| std_id      | INT (FK) |

---

## API Endpoints

### Book APIs

| Method | Endpoint    | Description    |
| ------ | ----------- | -------------- |
| POST   | /books      | Add Book       |
| GET    | /books      | Get All Books  |
| GET    | /books/{id} | Get Book By Id |
| PUT    | /books/{id} | Update Book    |
| DELETE | /books/{id} | Delete Book    |

### Student APIs

| Method | Endpoint       | Description       |
| ------ | -------------- | ----------------- |
| POST   | /students      | Add Student       |
| GET    | /students      | Get All Students  |
| GET    | /students/{id} | Get Student By Id |
| PUT    | /students/{id} | Update Student    |
| DELETE | /students/{id} | Delete Student    |

### Issue Book APIs

| Method | Endpoint                             | Description          |
| ------ | ------------------------------------ | -------------------- |
| POST   | /issue/book/{bookId}/student/{stdId} | Issue Book           |
| PUT    | /issue/return/{issueId}              | Return Book          |
| GET    | /issue                               | Get All Issued Books |
| GET    | /issue/{issueId}                     | Get Issue Details    |

---

## Sample Error Response

```json
{
  "message": "Book not found Id -> 10",
  "timestamp": "2026-06-11T23:45:12.123456"
}
```

---
