package com.example.MovieDekho.controller;

import com.example.MovieDekho.entity.City;
import com.example.MovieDekho.service.CityService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cities")
@RequiredArgsConstructor
public class CityController {

    private final CityService cityService;

    @GetMapping("/id/{id}")
    public ResponseEntity<City> getCityById(@PathVariable Long id) {
        return  ResponseEntity.ok(cityService.getCityById(id));
    }

    @GetMapping
    public ResponseEntity<List<City>>  getAllCity() {
        return ResponseEntity.ok(cityService.getAllCity())  ;
    }

    @GetMapping("/city/{name}")
    public ResponseEntity<City> getCityByName(@PathVariable String name) {
        return ResponseEntity.ok(cityService.getCityByName(name));
    }

    @PostMapping("/city/search")
    public ResponseEntity<City> addCity(@RequestBody City city) {
        return ResponseEntity.ok(cityService.addCity(city));
    }

    @GetMapping("/state/search")
    public ResponseEntity<List<City>> getCityByState(@RequestParam String state) {
        return ResponseEntity.ok(cityService.getCityByState(state));
    }
}
