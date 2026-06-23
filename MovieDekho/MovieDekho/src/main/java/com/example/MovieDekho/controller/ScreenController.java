package com.example.MovieDekho.controller;

import com.example.MovieDekho.entity.Screen;
import com.example.MovieDekho.service.ScreenService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/screens")
@RequiredArgsConstructor
public class ScreenController {

    private final ScreenService screenService;

    @GetMapping
    public ResponseEntity<List<Screen>> getAllSeats(){
        return ResponseEntity.ok(screenService.getScreens());
    }

    @PostMapping
    public ResponseEntity<Screen>  createScreen(@RequestBody Screen screen){
        return ResponseEntity.ok(screenService.addScreen(screen));
    }

    @GetMapping("/id/{id}")
    public ResponseEntity<Screen> getScreenById(@PathVariable Long id){
        return ResponseEntity.ok(screenService.getScreenById(id));
    }

    @GetMapping("/theater/{id}")
    public ResponseEntity<List<Screen>> getScreenByTheaterId( @PathVariable Long id){
        return ResponseEntity.ok(screenService.getScreensByTheaterId(id));
    }

}
