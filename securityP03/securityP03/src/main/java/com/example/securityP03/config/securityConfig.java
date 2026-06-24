package com.example.securityP03.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity(debug = true)
@EnableMethodSecurity(
        prePostEnabled = true,
        securedEnabled = true
)
public class securityConfig {


    private final UserDetailsService userDetailsService;
    @Autowired
    public securityConfig(UserDetailsService userDetailsService) {
        this.userDetailsService = userDetailsService;
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests(
                        req->
                                req.requestMatchers("/api/public/**").permitAll()
                                        .requestMatchers("/api/auth/**").permitAll()
                                        .requestMatchers("/h2-console/**").permitAll()
                                        .requestMatchers("/api/admin/**").hasRole("ADMIN")
                                        .requestMatchers("/api/user/**").authenticated()
                                        .anyRequest().authenticated()
                ).httpBasic(h->{})
                .csrf(csrf-> csrf.disable())
                .headers(h->
                        h.frameOptions(frame-> frame.sameOrigin()))
                .authenticationProvider(authenticationProvider());

        return http.build();
    }

    @Bean
    public AuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider detailsAuthenticationProvider = new DaoAuthenticationProvider(userDetailsService);
        detailsAuthenticationProvider.setPasswordEncoder(passwordEncoder());
        return detailsAuthenticationProvider;
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
