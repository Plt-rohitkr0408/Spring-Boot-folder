package com.example.MovieDekho.service;

import com.example.MovieDekho.dto.LoginRequest;
import com.example.MovieDekho.entity.User;
import com.example.MovieDekho.respository.UserRepository;
import com.example.MovieDekho.service.intface.UserServiceInterface;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService implements UserServiceInterface {

    private final UserRepository userRepository;

    @Override
    public User registerUser(User user) {
        if(userRepository.existsByEmail(user.getEmail())) {
            throw new RuntimeException("User already exists");
        }
        return userRepository.save(user);
    }

    @Override
    public User loginUser(LoginRequest loginRequest) {
        String email = loginRequest.getEmail();
        String password = loginRequest.getPassword();
        User user = userRepository.findByEmail(email);
        if(user == null){
            throw new RuntimeException("User not found");
        }
        if(!password.equals(user.getPassword())){
            throw new RuntimeException("Passwords don't match");
        }
        return user;
    }

    @Override
    public List<User> getUsers() {
        return userRepository.findAll();
    }

    @Override
    public User getUserById(Long userId) {
        return userRepository.findById(userId).
                orElseThrow(() -> new RuntimeException("User not found"));
    }
}
