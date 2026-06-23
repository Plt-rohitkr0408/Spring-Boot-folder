package com.example.MovieDekho.service.intface;

import com.example.MovieDekho.entity.Seat;

import java.util.List;

public interface SeatsServiceInterface {
    Seat addSeat(Seat seat);
    List<Seat> getSeat();
    Seat getSeatById(Long id);
    List<Seat> getSeatByScreenId(Long screenId);
}
