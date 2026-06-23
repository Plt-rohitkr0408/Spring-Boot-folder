# Employee Relationship Management System

A Spring Boot REST API project demonstrating Employee-Department relationship management using Spring Data JPA and MySQL.

The project follows a layered architecture and implements CRUD operations for both Employees and Departments while showcasing JPA entity relationships.

---

## Features

- Create, Update, Delete, and Retrieve Departments
- Create, Update, Delete, and Retrieve Employees
- Employee-Department Relationship Mapping
- RESTful APIs
- Spring Data JPA Integration
- MySQL Database Connectivity
- Exception Handling
- Clean Layered Architecture

---

## Tech Stack

### Backend
- Java 17+
- Spring Boot
- Spring Data JPA
- Hibernate
- Maven

### Database
- MySQL

### Tools
- IntelliJ IDEA
- Postman


---

## Project Structure

```text
src
 └── main
     ├── java
     │   └── com.example.Employee_rel_demo
     │       ├── controller
     │       │    ├── EmployeeController
     │       │    └── DepartmentController
     │       │
     │       ├── entity
     │       │    ├── Employee
     │       │    └── Department
     │       │
     │       ├── repository
     │       │    ├── EmployeeRepository
     │       │    └── DepartmentRepository
     │       │
     │       ├── services
     │       │    ├── EmployeeService
     │       │    ├── DepartmentService
     │       │    └── impl
     │       │
     │       ├── Exception
     │       │    └── ResourceException
     │       │
     │       └── EmployeeRelDemoApplication
     │
     └── resources
         └── application.properties
```

---

## Entity Relationship

### Employee Entity

An employee belongs to one department.

```java
@ManyToOne(fetch = FetchType.EAGER)
@JoinColumn(name = "emp_dept")
private Department department;
```

### Department Entity

A department can have multiple employees.

```java
@OneToMany(mappedBy = "department")
private List<Employee> employees;
```

Relationship:

```text
Department (1)
      |
      |
      |
      *
Employee (Many)
```

---

## Employee Attributes

| Field | Type |
|---------|---------|
| id | Integer |
| name | String |
| email | String |
| phone | String |
| salary | Double |
| department | Department |

---

## Department Attributes

| Field | Type |
|---------|---------|
| deptId | Integer |
| deptName | String |

---

## REST API Endpoints

### Department APIs

| Method | Endpoint | Description |
|----------|------------|-------------|
| POST | /departments | Create Department |
| GET | /departments | Get All Departments |
| GET | /departments/{id} | Get Department By Id |
| PUT | /departments/{id} | Update Department |
| DELETE | /departments/{id} | Delete Department |

---

### Employee APIs

| Method | Endpoint | Description |
|----------|------------|-------------|
| POST | /employees | Create Employee |
| GET | /employees | Get All Employees |
| GET | /employees/{id} | Get Employee By Id |
| PUT | /employees/{id} | Update Employee |
| DELETE | /employees/{id} | Delete Employee |

---

## Sample Request

### Create Department

```json
{
  "deptName": "IT"
}
```

### Create Employee

```json
{
  "name": "Rohit",
  "email": "rohit@gmail.com",
  "phone": "9876543210",
  "salary": 50000,
  "department": {
    "deptId": 1
  }
}
```

---

## Database Configuration

Configure your MySQL database in:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/jpa_rel_emp
spring.datasource.username=root
spring.datasource.password=your_password

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true

server.port=8080
```

---

## Exception Handling

Custom exception handling is implemented using:

```java
ResourceException
```

Used for:
- Employee Not Found
- Department Not Found
- Invalid Resource Requests

---

## How To Run

### Clone Repository

```bash
git clone https://github.com/your-username/Employee_rel_demo.git
```

### Navigate To Project

```bash
cd Employee_rel_demo
```

### Build Project

```bash
mvn clean install
```

### Run Application

```bash
mvn spring-boot:run
```

Application will start on:

```text
http://localhost:8080
```

---
