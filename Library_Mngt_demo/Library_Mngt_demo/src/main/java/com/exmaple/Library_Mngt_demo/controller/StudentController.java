package com.exmaple.Library_Mngt_demo.controller;

import com.exmaple.Library_Mngt_demo.entity.Student;
import com.exmaple.Library_Mngt_demo.service.StudentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {

    private final StudentService studentService;
    public StudentController(StudentService studentService)
    {
        this.studentService = studentService;
    }

    @PostMapping
    public Student addStudent(@RequestBody Student student)
    {
        return studentService.saveStudent(student);
    }

    @GetMapping
    public List<Student> getAllStudents()
    {
        return studentService.findAllStudent();
    }

    @GetMapping("/{id}")
    public  Student getStudentById( @PathVariable Integer id)
    {
        return studentService.findStudentById(id);
    }

    @PutMapping("/{id}")
    public Student updateStudent(@PathVariable Integer id , @RequestBody Student student)
    {
        return studentService.updateStudent(id, student);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteStudentById(@PathVariable int id)
    {
        studentService.deleteStudent(id);
        return ResponseEntity.ok().body("Delete student successfully");
    }

}
