package com.example.MovieDekho.respository;

import com.example.MovieDekho.entity.Theater;
import com.example.MovieDekho.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TheaterRepository extends JpaRepository<Theater, Long> {
    List<Theater> findByCityId(Long cityId);
}
