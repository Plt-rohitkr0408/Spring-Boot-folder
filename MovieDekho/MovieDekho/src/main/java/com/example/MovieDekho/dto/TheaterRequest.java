package com.example.MovieDekho.dto;

import com.example.MovieDekho.entity.City;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class TheaterRequest {
    private String theaterName;
    private String address;
    private Long cityId;
}
