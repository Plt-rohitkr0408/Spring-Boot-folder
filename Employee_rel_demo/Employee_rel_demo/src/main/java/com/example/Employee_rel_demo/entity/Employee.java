package com.example.Employee_rel_demo.entity;

import jakarta.persistence.*;

@Entity
@Table(name ="employees")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer  id;

    @Column(nullable = false, length = 30)
    private String name;

    @Column(nullable = false, length = 30 , unique = true)
    private String email;

    @Column(nullable = false, length = 10, unique = true)
    private String phone;

    @Column(nullable = false)
    private Double salary;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "emp_dept")
    private Department dept;
}
