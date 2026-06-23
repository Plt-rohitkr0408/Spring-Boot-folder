package com.example.securityP03.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/public")
public class PublicController {

    @GetMapping("/hello")
    public ResponseEntity<Map<String, Object>> hello(){
        Map<String, Object> map = new HashMap<>();
        map.put("message", "Hello World");
        map.put("code", 200);
        map.put("Authorized" ,"public");

        return ResponseEntity.ok(map);
    }


}
