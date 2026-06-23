package com.exmaple.Library_Mngt_demo.repository;

import com.exmaple.Library_Mngt_demo.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student,Integer> {
}
