package com.example.MovieProject.Controller;

import com.example.MovieProject.Entity.Movie;
import com.example.MovieProject.Service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/movies")
public class UserController {
    @Autowired
    private MovieService movieService;

    @GetMapping
    public List<Movie> getAllMovie(){
        return movieService.getAllMovies();
    }

    @GetMapping("/{id}")
    public Movie getMovieById(@PathVariable  Long id){
        return movieService.getMoviebyID(id);
    }

    @GetMapping("/search")
    public List<Movie> getMoviebyName(@RequestParam String name){
        return movieService.getMovieByName(name);
    }

    @PostMapping
    public Movie addMovie(@RequestBody Movie movie){
        return movieService.addMovie(movie);
    }
}
