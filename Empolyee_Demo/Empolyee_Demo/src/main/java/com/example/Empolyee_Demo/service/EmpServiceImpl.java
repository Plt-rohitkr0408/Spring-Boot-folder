package com.example.Empolyee_Demo.service;

import com.example.Empolyee_Demo.entity.Employee;
import com.example.Empolyee_Demo.repository.EmpolyeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmpServiceImpl implements EmpolyeeService {

    @Autowired
    private EmpolyeeRepository empolyeeRepository;

    @Override
    public List<Employee> getAllEmpolyee() {
        return empolyeeRepository.findAll();
    }

    @Override
    public Employee getById(int id) {
        return empolyeeRepository.findById(id).orElseThrow(()-> new RuntimeException("employee not found"));
    }

    @Override
    public Employee updateEmployee(Integer id, Employee employee) {
        Employee existingEmployee = empolyeeRepository.findById(id).orElseThrow(()-> new RuntimeException("employee not found"));
        existingEmployee.setName(employee.getName());
        existingEmployee.setDepartment(employee.getDepartment());
        existingEmployee.setEmail(employee.getEmail());
        existingEmployee.setSalary(employee.getSalary());
        return empolyeeRepository.save(existingEmployee);
    }


    @Override
    public String delete(Integer id) {
        Employee employee1 = empolyeeRepository.findById(id).orElseThrow(()-> new RuntimeException("employee not found"));
        empolyeeRepository.delete(employee1);
        return "employee deleted successfully";
    }

    @Override
    public Employee addEmpolyee(Employee employee) {
        return empolyeeRepository.save(employee);
    }
}
