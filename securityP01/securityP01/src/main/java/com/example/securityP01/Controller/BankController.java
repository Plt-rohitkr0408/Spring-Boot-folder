package com.example.securityP01.Controller;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class BankController {

    @GetMapping("/user")
    public Map<String,Object> userRequest(){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        Map<String,Object> map = new HashMap<>();
        map.put("message","this is User ");
        map.put("localtimeDate", LocalDateTime.now().toString());
        map.put("userinfo",userInfo(auth));
        return map;
    }

    @GetMapping("/admin")
    public Map<String,Object> adminRequest(){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        Map<String,Object> map = new HashMap<>();
        map.put("message","this is Admin ");
        map.put("localtimeDate", LocalDateTime.now().toString());
        map.put("userinfo",userInfo(auth));
        return map;
    }

    public Map<String,Object> userInfo(Authentication auth){
        Map<String,Object> map = new HashMap<>();
        map.put("username",auth.getName());
        map.put("authorities",auth.getAuthorities());
        map.put("token",auth.getCredentials());
        return map;
    }
}