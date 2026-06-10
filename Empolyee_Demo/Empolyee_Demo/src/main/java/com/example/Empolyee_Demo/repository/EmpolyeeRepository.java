package com.example.Empolyee_Demo.repository;

import com.example.Empolyee_Demo.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmpolyeeRepository extends JpaRepository<Employee,Integer> {
}
