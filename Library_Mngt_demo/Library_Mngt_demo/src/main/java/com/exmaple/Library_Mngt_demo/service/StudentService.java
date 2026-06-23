package com.exmaple.Library_Mngt_demo.service;

import com.exmaple.Library_Mngt_demo.entity.Student;

import java.util.List;

public interface StudentService {
    Student saveStudent(Student student);
    List<Student> findAllStudent();
    Student findStudentById(Integer id);
    Student updateStudent(Integer id ,Student student);
    void deleteStudent(Integer id);

}
