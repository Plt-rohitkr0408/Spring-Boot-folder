package com.example.MovieDekho.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalTime;
import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GloberExceptionHandler {

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<Map<String,Object>> handleException(RuntimeException ex){
        Map<String,Object> map = new HashMap<>();
        map.put("message: ",ex.getMessage());
        map.put("timestamp" , LocalTime.now());
        map.put("statusCode", HttpStatus.BAD_REQUEST.value());
        return ResponseEntity.badRequest().body(map);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<Map<String, Object>> handleExceptins(Exception ex){
        Map<String,Object> map = new HashMap<>();
        map.put("message: ",ex.getMessage());
        map.put("timestamp" , LocalTime.now());
        map.put("statusCode", HttpStatus.INTERNAL_SERVER_ERROR.value());
        return ResponseEntity.badRequest().body(map);
    }
}
