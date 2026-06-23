package com.example.MovieDekho.dto;

import com.example.MovieDekho.enums.SeatType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SeatRequest {

    private String seatNumber;
    private SeatType seatType;
    private Long screenId;

}
