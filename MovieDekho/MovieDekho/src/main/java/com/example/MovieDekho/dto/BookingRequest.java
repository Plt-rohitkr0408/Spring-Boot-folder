package com.example.MovieDekho.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Setter
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class BookingRequest {
    private Long userId;
    private Long showId;
    private List<Long> seatId;
}
