package com.example.practice.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class StudentService {

    private final CourseService courseService;
    private final PaymentService paymentService;

    StudentService(@Qualifier("javaCourse") CourseService courseService, PaymentService paymentService) {
        this.courseService = courseService;
        this.paymentService = paymentService;
    }

    void enrolledStudent(){
        System.out.println("1. Student enrollment Started");
        courseService.getCourseDetail();
        paymentService.doPayment();
        System.out.println("Student enrolled successfully");
    }

}
