package com.example.MovieDekho.service.intface;

import com.example.MovieDekho.dto.LoginRequest;
import com.example.MovieDekho.entity.User;

import java.util.List;

public interface UserServiceInterface {
    User registerUser(User user);
    User loginUser(LoginRequest loginRequest);
    List<User> getUsers();
    User getUserById(Long userId);
}
