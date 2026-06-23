package com.example.JobPortalProject.config;

import org.apache.coyote.Response;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<Map<String,Object>> handleException(RuntimeException ex){

        Map<String,Object> map = new HashMap<>();
        map.put("message", ex.getMessage());
        map.put("status", HttpStatus.INTERNAL_SERVER_ERROR.value());
        map.put("timestamp", System.currentTimeMillis());

        return ResponseEntity.ok().body(map);
    }
}
