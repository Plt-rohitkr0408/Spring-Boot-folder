package com.example.Employee_rel_demo.repository;

import com.example.Employee_rel_demo.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepository extends JpaRepository<Department,Integer> {
}
