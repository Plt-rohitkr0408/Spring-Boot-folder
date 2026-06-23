package com.example.Employee_rel_demo.controller;

import com.example.Employee_rel_demo.entity.Employee;
import com.example.Employee_rel_demo.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    @PostMapping("/department/{id}")
    public Employee save(@PathVariable Integer id, @RequestBody Employee employee) {
        return employeeService.save(id, employee);
    }

    @GetMapping("/{id}")
    public Employee getEmployeeById(Integer id) {
        return employeeService.getEmployeeById(id);
    }

    @GetMapping
    public List<Employee> getAllEmployees() {
        return employeeService.getAllEmployees();
    }

    @PutMapping("/{id}")
    public Employee updateEmployee(@PathVariable Integer id,@RequestBody Employee employee) {
        return employeeService.updateEmployee(id, employee);
    }

    @DeleteMapping("/{id}")
    public String deleteEmployee(@PathVariable Integer id) {
        return employeeService.deleteEmployee(id);
    }

}
