package com.example.practice.services.impl;

import com.example.practice.services.CourseService;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

@Service
public class JavaCourse implements CourseService {
    @Override
    public void getCourseDetail(){
        System.out.println("Java Course Detail----");
    }
}
