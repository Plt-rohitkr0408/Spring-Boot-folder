package com.example.securityP01.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/public")
public class PublicController {

    @GetMapping("/hello")
    public String hello(){
        return "Hello Sir....";
    }



    @GetMapping("/bye")
    public String bye(){
        return "bye.....";
    }
}
