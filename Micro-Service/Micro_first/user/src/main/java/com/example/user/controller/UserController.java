package com.example.user.controller;

import com.example.user.Model.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {
    private List<User> users = Arrays.asList(
            new User(1L, "A" ,"a@gmail.com" ,"123456"),
            new User(2L, "B" ,"b@gmail.com" ,"123456"),
            new User(3L, "C" ,"c@gmail.com" ,"123456"),
            new User(4L, "D" ,"d@gmail.com" ,"123456")
    );

    @GetMapping
    public List<User> getAllUsers() {
        return users;
    }

    @GetMapping("/{id}")
    public User getUserById(@PathVariable Long id) {
        return users.stream()
                .filter(user -> user.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

}
