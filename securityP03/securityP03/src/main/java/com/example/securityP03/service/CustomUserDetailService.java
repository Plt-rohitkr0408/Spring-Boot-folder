package com.example.securityP03.service;

import com.example.securityP03.entity.User;
import com.example.securityP03.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.stream.Collectors;

@Service
public class CustomUserDetailService implements UserDetailsService {
    private  UserRepository userRepository;
    @Autowired
    public CustomUserDetailService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

       User existingUser=  userRepository.findByUsername(username)
               .orElseThrow(() -> new UsernameNotFoundException("Username not found"));

        return buildUserDetail(existingUser);
    }

    public UserDetails buildUserDetail(User requrestUser){

       Collection<GrantedAuthority> authorities = requrestUser.getRole().stream()
                .map(role-> {
                        String roleName = role.getTitle().startsWith("ROLE_") ? role.getTitle() : "ROLE_"+role.getTitle();
                        return new SimpleGrantedAuthority(roleName);
                }).collect(Collectors.toList());
       return org.springframework.security.core.userdetails.User.builder()
               .username(requrestUser.getUsername())
               .password(requrestUser.getPassword())
               .authorities(authorities)
               .accountExpired(false)
               .accountLocked(!requrestUser.getAccountNonExpired())
               .credentialsExpired(false)
               .disabled( !requrestUser.isEnable())
               .build();
    }
}
