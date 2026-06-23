package com.example.MovieDekho.controller;

import com.example.MovieDekho.entity.Movie;
import com.example.MovieDekho.service.MovieService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/movies")
@RequiredArgsConstructor
public class MovieController {

    private final MovieService movieService;

    @PostMapping("/add")
    public ResponseEntity<Movie> addMovie(@RequestBody Movie movie) {
        return ResponseEntity.ok(movieService.addMovie(movie));
    }

    @GetMapping("/id/{id}")
    public ResponseEntity<Movie> getMovieById(@PathVariable Long id) {
        return ResponseEntity.ok(movieService.getMovieById(id));
    }

    @GetMapping
    public ResponseEntity<List<Movie>> getAllMovies() {
        return ResponseEntity.ok(movieService.getAllMovies());
    }

    @GetMapping("/genre/{genre}")
    public ResponseEntity<List<Movie>> getMovieByGenre(@PathVariable String genre) {
        return ResponseEntity.ok(movieService.getMovieByGenre(genre));
    }

    @GetMapping("/search")
    public ResponseEntity<List<Movie>> getMovieByTitle( @RequestParam String title) {
        return ResponseEntity.ok(movieService.getMovieByTitle(title));
    }

    @GetMapping("/search/language")
    public ResponseEntity<List<Movie>> getMovieByLanguage(@RequestParam String language) {
        return ResponseEntity.ok(movieService.getMovieByLanguage(language));
    }

}
