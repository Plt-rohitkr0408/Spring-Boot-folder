package com.example.MovieDekho.service.intface;

import com.example.MovieDekho.entity.Theater;

import java.util.List;

public interface TheaterServiceInterface {
    Theater addTheater(Theater theater);
    List<Theater> getTheaters();
    Theater getTheaterById(Long id);
    List<Theater> getTheaterByCityId(Long cityId);
}
