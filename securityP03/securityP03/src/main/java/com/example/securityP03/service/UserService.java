package com.example.securityP03.service;

import com.example.securityP03.dto.UserRequest;
import com.example.securityP03.entity.Role;
import com.example.securityP03.entity.User;
import com.example.securityP03.repository.RoleRepository;
import com.example.securityP03.repository.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import java.util.List;


@Service
public class UserService {
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public UserService(UserRepository userRepository, RoleRepository roleRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.passwordEncoder = passwordEncoder;
    }


    @Transactional
    public User registerUser(UserRequest  userRequest) {
        if ( userRepository.existsByUsername(userRequest.getUsername())) {
            throw new RuntimeException("User already exists");
        }
        if(userRepository.existsByEmail(userRequest.getEmail())){
            throw new RuntimeException("Email already exists");
        }

        Role userRole = roleRepository.findByTitle("USER")
                .orElseGet(()-> roleRepository.save(Role.builder()
                        .title("USER")
                        .description("Standard User")
                        .build()));

        User newUser = User.builder()
                .username(userRequest.getUsername())
                .email(userRequest.getEmail())
                .password(passwordEncoder.encode(userRequest.getPassword()))
                .fullName(userRequest.getFullname())
                .build();

        newUser.addRole(userRole);

        return userRepository.save(newUser);
    }

    @Transactional
    public User adminRegister(UserRequest request){
       if(userRepository.existsByUsername(request.getUsername())){
           throw new RuntimeException("User already exists");
       }
       if(userRepository.existsByEmail(request.getEmail())){
           throw new RuntimeException("Email already exists");
       }

       Role role = roleRepository.findByTitle("ADMIN")
               .orElseGet(()-> roleRepository.save(Role.builder()
                               .title("ADMIN")
                               .description("Admin User")
                       .build()));

       User adminUser = User.builder()
               .username(request.getUsername())
               .email(request.getEmail())
               .password(passwordEncoder.encode(request.getPassword()))
               .fullName(request.getFullname())
               .build();
       adminUser.addRole(role);
       return userRepository.save(adminUser);

    }

    public User finByUsername(String username) {
        return userRepository.findByUsername(username)
                .orElseThrow(()-> new RuntimeException("User not found"));
    }

    public List<User> findAll() {
        return userRepository.findAll();
    }
}
