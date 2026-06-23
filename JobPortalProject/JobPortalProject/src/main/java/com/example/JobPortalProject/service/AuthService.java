package com.example.JobPortalProject.service;


import com.example.JobPortalProject.Repository.UserRepository;
import com.example.JobPortalProject.dto.AuthResponse;
import com.example.JobPortalProject.dto.LoginRequest;
import com.example.JobPortalProject.dto.RegisteRequest;
import com.example.JobPortalProject.entity.User;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    private final  UserRepository userRepository;

    private final PasswordEncoder passwordEncoder;

    private  final JwtService jwtService;

    private final AuthenticationManager authenticationManager;

    public AuthService(UserRepository userRepository, PasswordEncoder passwordEncoder, JwtService jwtService, AuthenticationManager authenticationManager) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.jwtService = jwtService;
        this.authenticationManager = authenticationManager;
    }

    public void register(RegisteRequest registeRequest) {
        if(userRepository.existsByEmail(registeRequest.getEmail())) {
            throw new RuntimeException("Email Already Exists");
        }

        System.out.println(registeRequest.getUsername());
        User user = User.builder()
                .username(registeRequest.getUsername())
                .email(registeRequest.getEmail())
                .password(passwordEncoder.encode(registeRequest.getPassword()))
                .role(registeRequest.getRole())
                .build();
        userRepository.save(user);
    }

    public AuthResponse login(LoginRequest loginRequest) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        loginRequest.getEmail(),
                        loginRequest.getPassword()
                )
        );

      UserDetails userDetails = (UserDetails) authentication.getPrincipal();

        User user = userRepository.findByEmail(userDetails.getUsername())
                .orElseThrow(() -> new UsernameNotFoundException("Email Not Found"));

        String token = jwtService.generateToken(userDetails);
        return new AuthResponse(token);
    }


}
