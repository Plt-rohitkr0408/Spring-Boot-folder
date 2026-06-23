package com.example.MovieDekho.controller;


import com.example.MovieDekho.entity.Movie;
import com.example.MovieDekho.entity.Theater;
import com.example.MovieDekho.service.TheaterService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/theaters")
@RequiredArgsConstructor
public class TheaterController {

    private final TheaterService theaterService;

    @GetMapping("/{id}")
    public ResponseEntity<Theater> getTheaterByID(@PathVariable Long id){
        return  ResponseEntity.ok(theaterService.getTheaterById(id));
    }

    @GetMapping
    public ResponseEntity<List<Theater>> getAllTheaters(){
        return ResponseEntity.ok(theaterService.getTheaters());
    }
    @PostMapping
    public ResponseEntity<Theater> addTheater(@RequestBody Theater theater){
        return ResponseEntity.ok(theaterService.addTheater(theater));
    }

    @GetMapping("/cityId/{cityId}")
    public ResponseEntity<List<Theater>> getTheaterByCity(@PathVariable Long cityId){
        return ResponseEntity.ok(theaterService.getTheaterByCityId(cityId));
    }

}
