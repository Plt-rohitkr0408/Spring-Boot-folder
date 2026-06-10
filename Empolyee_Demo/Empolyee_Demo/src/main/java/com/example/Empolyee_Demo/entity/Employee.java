package com.example.Empolyee_Demo.entity;

import jakarta.persistence.*;

@Entity
@Table(name= "employees")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false , length = 30)
    private String name;

    @Column(nullable = false , length = 50)
    private String email;

    @Column(nullable = false , length = 50)
    private String department;

    @Column(nullable = false)
    private String salary;

    @Transient
    private String demmy;

    public Employee() {
    }
    public Employee(Integer id ,String name, String email, String department, String salary) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.department = department;
        this.salary = salary;
        this.demmy = "";
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDepartment() {
        return this.department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getSalary() {
        return salary;
    }

    public void setSalary(String salary) {
        this.salary = salary;
    }

    public String getDemmy() {
        return demmy;
    }

    public void setDemmy(String demmy) {
        this.demmy = demmy;
    }
}
