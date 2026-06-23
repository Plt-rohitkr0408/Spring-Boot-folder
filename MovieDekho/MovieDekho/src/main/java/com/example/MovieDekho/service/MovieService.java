package com.example.MovieDekho.service;

import com.example.MovieDekho.entity.Movie;
import com.example.MovieDekho.respository.MovieRepository;
import com.example.MovieDekho.service.intface.MovieServiceInterface;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor
public class MovieService implements MovieServiceInterface {

    private final MovieRepository movieRepository;


    @Override
    public Movie addMovie(Movie movie) {
        return movieRepository.save(movie);
    }

    @Override
    public Movie getMovieById(Long id) {
        return movieRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Movie not found"));
    }

    @Override
    public List<Movie> getAllMovies() {
        return movieRepository.findAll();
    }

    @Override
    public List<Movie> getMovieByGenre(String genre) {
        return movieRepository.findByGenre(genre);
    }

    @Override
    public List<Movie> getMovieByTitle(String title) {
        return movieRepository.findByTitleContainingIgnoreCase(title);
    }

    @Override
    public List<Movie> getMovieByLanguage(String language) {
        return movieRepository.findByLanguage(language);
    }
}
