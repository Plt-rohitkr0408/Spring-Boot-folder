package com.example.MovieProject.Service;

import com.example.MovieProject.Entity.Movie;
import com.example.MovieProject.Repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieService {

    @Autowired
    private MovieRepository movieRepository;

    public List<Movie> getAllMovies() {
        return movieRepository.getAllMovies();
    }
    public Movie getMoviebyID(Long id) {
        return movieRepository.getMovieById(id);
    }
    public Movie addMovie(Movie movie) {
        return movieRepository.addMovie(movie);
    }

    public List<Movie> getMovieByName(String name) {
        return movieRepository.getMovieByName(name);
    }
}
