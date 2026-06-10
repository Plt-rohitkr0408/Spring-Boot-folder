
package com.example.MovieProject.Repository;

import com.example.MovieProject.Entity.Movie;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.*;
import java.util.stream.Collectors;

@Repository
public class MovieRepository {
    private final Map<Long, Movie> movieDb = new HashMap<>();

    @PostConstruct
    public void addMovie(){
        movieDb.put(1L , new Movie(1L ,"Dhurandhar" , 2025 , 9.8 ,"Socialist" , "Aditya Dhar"));
        movieDb.put(2L , new Movie(2L ,"KGF" , 2023 , 9.5 ,"Action" , "xyz"));
        movieDb.put(3L , new Movie(3L ,"Pushpa" , 2022 , 9.2 ,"Action + Drama" , "south Director"));
        movieDb.put(4L , new Movie(4L ,"Money Hist" , 2025 , 9.8 ,"Action+thief" , "Germany Director"));
        movieDb.put(5L , new Movie(5L ,"3-idiots" , 2012 , 9.8 ,"Sci-fi" , "North Director"));
    }

    public List<Movie> getAllMovies(){
        return new ArrayList<>(movieDb.values());
    }

    public Movie getMovieById(Long id){
        return movieDb.get(id);
    }

    public List<Movie> getMovieByName(String Moviename){
//        System.out.println("getMovieByName "+Moviename);
        return movieDb.values()
                .stream()
                .filter(movie -> movie.getMovieName() != null && movie.getMovieName().toLowerCase().contains(Moviename.toLowerCase()))
                .collect(Collectors.toList());
    }

    public Movie addMovie(Movie movie){
        movieDb.put(movie.getId(),  movie);
        return movie;
    }
}