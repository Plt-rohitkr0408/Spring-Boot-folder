package com.example.MovieDekho.respository;

import com.example.MovieDekho.entity.Screen;
import com.example.MovieDekho.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ScreenRepository extends JpaRepository<Screen, Long> {
    List<Screen> findByTheaterId(Long theaterId);
}
