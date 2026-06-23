package com.example.JobPortalProject.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class TestController {


    @GetMapping("/t1")
    public String testApi(){
        System.out.println("----------------------testApi-----------------------");
        return "Welcome to Job Portal";
    }

    @GetMapping("/user")
    public ResponseEntity<String> getcurrentUser(){
        String email  = SecurityContextHolder.getContext().getAuthentication().getName();
        return ResponseEntity.ok(email);
    }
}
