package com.example.securityP03.controller;

import com.example.securityP03.dto.UserRequest;
import com.example.securityP03.entity.User;
import com.example.securityP03.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private final UserService userService;
    @Autowired
    public AuthController(UserService userService) {
        this.userService = userService;
    }
    @GetMapping
    public ResponseEntity<String> getAllAuth(){
        return ResponseEntity.ok( "Registation auth is public  ");
    }

    @PostMapping("/registerUser")
    public ResponseEntity< Map<String,Object>> registerUser(@Valid @RequestBody UserRequest request)
    {
        try{
           User user = userService.registerUser(request);
           Map<String,Object> map = new HashMap<>();
           map.put("success",true);
           map.put("username",user.getUsername());
           map.put("message","user registered successfully");
           map.put("Authorized", user.getRole().stream()
                   .map(role-> role.getTitle()).toList()
           );
           return ResponseEntity.ok(map);

        }catch(Exception ex){
            Map<String,Object> map = new HashMap<>();
            map.put("success",false);
            map.put("message",ex.getMessage());
            return ResponseEntity.ok(map);
        }
    }

    @PostMapping("/register-admin")
    public ResponseEntity<Map<String,Object>>  registerAdmin(@Valid @RequestBody UserRequest request){
        try{
            User user = userService.adminRegister(request);
            Map<String,Object> map = new HashMap<>();
            map.put("success",true);
            map.put("username",user.getUsername());
            map.put("message","Admin registered successfully");
            map.put("Authorized", user.getRole().stream().map(role-> role.getTitle()).toList());

            return ResponseEntity.ok(map);
        }catch(Exception ex){
            Map<String,Object> map = new HashMap<>();
            map.put("success",false);
            map.put("message",ex.getMessage());
            return ResponseEntity.ok(map);
        }


    }

    @GetMapping("/register")
    public ResponseEntity<List<User>>  register(){
        return ResponseEntity.ok(userService.findAll());
    }
}
