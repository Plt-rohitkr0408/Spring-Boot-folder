package com.example.securityP03.controller;

import com.example.securityP03.entity.User;
import com.example.securityP03.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/user")
public class UserController {
    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public ResponseEntity<List<User>> getAllUser(){
        return ResponseEntity.ok(userService.findAll());
    }

    @GetMapping("/course")
    public ResponseEntity<String> course(){
        return ResponseEntity.ok("Course Enrolled");
    }

    @GetMapping("/profile")
    public ResponseEntity<String> profile(){
        return ResponseEntity.ok("You are Student");
    }

}
