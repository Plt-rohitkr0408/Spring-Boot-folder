package com.example.Employee_rel_demo.services.impl;

import com.example.Employee_rel_demo.entity.Department;
import com.example.Employee_rel_demo.repository.DepartmentRepository;
import com.example.Employee_rel_demo.services.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.module.ResolutionException;
import java.util.List;

@Service
public class DepartmentServiceImpl implements DepartmentService {

    @Autowired
    private DepartmentRepository departmentRepository;

    @Override
    public Department saveDepartment(Department department) {
        return departmentRepository.save(department);
    }

    @Override
    public List<Department> getDepartments() {
        return departmentRepository.findAll();
    }

    @Override
    public Department getDepartmentById(Integer id) {
        return departmentRepository.findById(id)
                .orElseThrow(()-> new ResolutionException("Department not found for id " + id));
    }

    @Override
    public Department updateDepartment(Integer id, Department department) {
        Department existingDepartment= departmentRepository.findById(id)
                .orElseThrow(()-> new ResolutionException("Department not found for id " + id));
        existingDepartment.setDeptId(id);
        existingDepartment.setDeptName(department.getDeptName());
        existingDepartment.setLocation(department.getLocation());
        return departmentRepository.save(existingDepartment);
    }

    @Override
    public String deleteDepartment(Integer id) {
        Department existingDepartment = departmentRepository.findById(id).orElseThrow(()-> new ResolutionException("Department not found for id " + id));
        departmentRepository.delete(existingDepartment);
        return "Department with id " + id + " and " + existingDepartment.getDeptName()+" has been deleted";
    }
}
