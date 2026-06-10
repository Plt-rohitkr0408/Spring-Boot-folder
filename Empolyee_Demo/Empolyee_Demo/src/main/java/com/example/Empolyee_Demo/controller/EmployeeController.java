package com.example.Empolyee_Demo.controller;

import com.example.Empolyee_Demo.entity.Employee;
import com.example.Empolyee_Demo.service.EmpolyeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.service.annotation.PostExchange;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
    @Autowired
    EmpolyeeService empolyeeService;

    @GetMapping
    public List<Employee> getEmpolyeeList(){
        return empolyeeService.getAllEmpolyee();
    }

    @GetMapping("/{id}")
    public Employee getEmpolyeeById(@PathVariable Integer id){
        return empolyeeService.getById(id);
    }

    @PostMapping
    public Employee addEmployee(@RequestBody Employee employee) {
        return empolyeeService.addEmpolyee(employee);
    }

}
