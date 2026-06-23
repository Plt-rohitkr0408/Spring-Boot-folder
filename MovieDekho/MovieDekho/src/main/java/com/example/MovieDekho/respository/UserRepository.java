package com.example.MovieDekho.respository;

import com.example.MovieDekho.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByEmail(String email);
    User findByPhone(String phone);
    boolean existsByEmail(String email);

}
