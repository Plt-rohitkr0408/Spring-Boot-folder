package com.example.Employee_rel_demo.services;

import java.util.*;
import com.example.Employee_rel_demo.entity.Department;

public interface DepartmentService {
    Department saveDepartment(Department department);
    List<Department> getDepartments();
    Department getDepartmentById(Integer id);
    Department updateDepartment(Integer id ,Department department);
    String deleteDepartment(Integer id);
}
