package com.exmaple.Library_Mngt_demo.service.impl;

import com.exmaple.Library_Mngt_demo.entity.Student;
import com.exmaple.Library_Mngt_demo.exception.ResourceException;
import com.exmaple.Library_Mngt_demo.repository.StudentRepository;
import com.exmaple.Library_Mngt_demo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    private StudentRepository studentRepository;

    @Override
    public Student saveStudent(Student student) {
        return studentRepository.save(student);
    }

    @Override
    public List<Student> findAllStudent() {
        return studentRepository.findAll();
    }

    @Override
    public Student findStudentById(Integer id) {
        return studentRepository.findById(id)
                .orElseThrow(()-> new ResourceException("Student not found"));
    }

    @Override
    public Student updateStudent(Integer id, Student student) {
        Student currentStudent = findStudentById(id);
        currentStudent.setStdName(student.getStdName());
        currentStudent.setEmail(student.getEmail());
        currentStudent.setPhoneNo(student.getPhoneNo());
        return studentRepository.save(currentStudent);
    }

    @Override
    public void deleteStudent(Integer id) {
        studentRepository.deleteById(id);
        System.out.println("Delete student successfully");
    }
}
