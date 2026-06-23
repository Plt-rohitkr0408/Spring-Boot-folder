package com.example.MovieDekho.controller;

import com.example.MovieDekho.dto.LoginRequest;
import com.example.MovieDekho.entity.User;
import com.example.MovieDekho.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/user")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public ResponseEntity<User> registerUser(@RequestBody User user){
        return ResponseEntity.ok(userService.registerUser(user));
    }

    @GetMapping
    public ResponseEntity<List<User>> getAllUser(){
        return ResponseEntity.ok(userService.getUsers());
    }

    @PostMapping("/signin")
    public ResponseEntity<User> loginUser( @RequestBody LoginRequest loginRequest){
        return  ResponseEntity.ok(userService.loginUser(loginRequest));
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getUserByID(@PathVariable Long id){
        return ResponseEntity.ok(userService.getUserById(id));
    }

}
