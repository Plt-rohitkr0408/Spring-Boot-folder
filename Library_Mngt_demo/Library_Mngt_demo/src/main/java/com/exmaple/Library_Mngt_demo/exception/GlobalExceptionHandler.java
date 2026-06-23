package com.exmaple.Library_Mngt_demo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ResourceException.class)
    public ResponseEntity<ErrorResponse> handleResourceException(
            ResourceException ex) {
    ErrorResponse errorResponse = new ErrorResponse(ex.getMessage() , LocalDateTime.now());

    return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
    }
}
