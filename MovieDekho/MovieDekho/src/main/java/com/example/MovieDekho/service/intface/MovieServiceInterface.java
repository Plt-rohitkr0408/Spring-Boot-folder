package com.example.MovieDekho.service.intface;

import com.example.MovieDekho.entity.Movie;

import java.time.LocalDate;
import java.util.List;

public interface MovieServiceInterface {
    Movie addMovie(Movie movie);
    Movie getMovieById(Long id);
    List<Movie> getAllMovies();
    List<Movie> getMovieByGenre(String genre);
    List<Movie> getMovieByTitle(String title);
    List<Movie> getMovieByLanguage(String language);

}
