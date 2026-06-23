package com.example.Employee_rel_demo.services;

import com.example.Employee_rel_demo.entity.Employee;

import java.util.List;

public interface EmployeeService {
    Employee save(Integer id ,Employee employee);
    List<Employee> getAllEmployees();
    Employee getEmployeeById(Integer id);
    Employee updateEmployee(Integer id ,Employee employee);
    String deleteEmployee(Integer id);
}
