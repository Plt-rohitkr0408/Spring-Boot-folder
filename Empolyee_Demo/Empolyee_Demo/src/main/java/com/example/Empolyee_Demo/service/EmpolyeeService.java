package com.example.Empolyee_Demo.service;

import com.example.Empolyee_Demo.entity.Employee;

import java.util.List;

public interface EmpolyeeService {

    String delete(Integer id);

    Employee addEmpolyee(Employee employee);
    List<Employee> getAllEmpolyee();
    Employee getById(int id);
    Employee updateEmployee(Integer id, Employee employee);
    String delete(Employee employee);


}
