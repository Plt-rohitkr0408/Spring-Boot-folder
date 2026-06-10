package com.example.Employee_rel_demo.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name ="dept_id")
    private Integer deptId;

    @Column(name= "dept_name", unique = true, nullable = false, length = 50)
    private String deptName;

    @OneToMany(mappedBy ="department" ,cascade = CascadeType.ALL , fetch = FetchType.EAGER)
    @JsonIgnore
    private List<Employee> employees = new ArrayList<>();

    public Department(){

    }
    public Department(Integer deptId, String deptName) {
        this.deptId = deptId;
        this.deptName = deptName;
    }

}
