package com.example.Employee_rel_demo.services.impl;

import com.example.Employee_rel_demo.entity.Department;
import com.example.Employee_rel_demo.entity.Employee;
import com.example.Employee_rel_demo.repository.DepartmentRepository;
import com.example.Employee_rel_demo.repository.EmployeeRepository;
import com.example.Employee_rel_demo.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.module.ResolutionException;
import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;
    @Autowired
    private DepartmentRepository departmentRepository;

    @Override
    public Employee save(Integer id, Employee employee) {
        Department department = departmentRepository.findById(id).orElseThrow(()-> new ResolutionException("Department Not Found"));
        employee.setDepartment(department);
        return employeeRepository.save(employee);
    }

    @Override
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee getEmployeeById(Integer id) {
        return employeeRepository.findById(id).orElseThrow(()-> new ResolutionException("Employee Not Found for id " + id));
    }

    @Override
    public Employee updateEmployee(Integer id,Employee employee) {
        Employee existingEmployee = getEmployeeById(id);
        existingEmployee.setName(employee.getName());
        existingEmployee.setSalary(employee.getSalary());
        existingEmployee.setEmail(employee.getEmail());

        if(employee.getDepartment()!=null && employee.getDepartment().getDeptId()!=null){
            Department department = departmentRepository.findById(employee.getDepartment().getDeptId()).orElseThrow(()-> new ResolutionException("Department Not Found"));
            existingEmployee.setDepartment(department);
        }

        return employeeRepository.save(existingEmployee);
    }

    @Override
    public String deleteEmployee(Integer id) {

        if( !employeeRepository.existsById(id)){
            throw new ResolutionException("Employee Not Found for id " + id);
        }

        Employee existingEmployee = getEmployeeById(id);
        employeeRepository.delete(existingEmployee);

        return "Employee Deleted Successfully";
    }
}
