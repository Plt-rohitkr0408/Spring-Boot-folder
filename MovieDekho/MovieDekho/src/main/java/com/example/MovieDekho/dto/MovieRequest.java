package com.example.MovieDekho.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class MovieRequest {
    private String title;
    private String description;
    private String genre;
    private String language;
    private LocalDate releaseDate;
    private Integer durationMinutes;
    private String posterUrl;

}
