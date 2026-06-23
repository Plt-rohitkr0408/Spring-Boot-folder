package com.example.securityP03.repository;

import com.example.securityP03.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByTitle(String title);
    boolean existsByTitle(String Title);

}
