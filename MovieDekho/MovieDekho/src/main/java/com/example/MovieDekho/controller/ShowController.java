package com.example.MovieDekho.controller;

import com.example.MovieDekho.entity.Show;
import com.example.MovieDekho.service.ShowService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/shows")
@RequiredArgsConstructor
public class ShowController {
    private final ShowService showService;

    @PostMapping("/post")
    public ResponseEntity<Show> addShow( @RequestBody Show show){
        return ResponseEntity.ok(showService.addShow(show));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Show> getShowById(@PathVariable Long id){
        return ResponseEntity.ok(showService.getShowById(id));
    }

    @GetMapping
    public ResponseEntity<List<Show>> getAllShow(){
        return ResponseEntity.ok(showService.getAllShow());
    }

    @GetMapping("/screen/{screenId}")
    public ResponseEntity<List<Show>> getShowByScreenId( @PathVariable Long screenId){
        return ResponseEntity.ok(showService.getShowByScreenId(screenId));
    }

    @GetMapping("/movie/{movieId}")
    public ResponseEntity<List<Show>> getShowByMovieId(@PathVariable Long movieId){
        return ResponseEntity.ok(showService.getShowByMovieId(movieId));
    }
    @GetMapping("/movie/{movieId}/search")
    public ResponseEntity<List<Show>> getShowByMovieAndDate( @PathVariable Long movieId,
                           @RequestParam @DateTimeFormat(iso= DateTimeFormat.ISO.DATE) LocalDate showDate){
        return ResponseEntity.ok(showService.getShowByMovieAndDate(movieId,showDate));
    }

}
