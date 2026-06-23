package com.example.MovieDekho.service;

import com.example.MovieDekho.entity.Seat;
import com.example.MovieDekho.respository.ScreenRepository;
import com.example.MovieDekho.respository.SeatRepository;
import com.example.MovieDekho.service.intface.SeatsServiceInterface;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SeatService implements SeatsServiceInterface {

    private final SeatRepository seatRepository;
    private final ScreenRepository screenRepository;

    @Override
    public Seat addSeat(Seat seat) {

        Long screenId = seat.getScreen().getId();

        screenRepository.findById(screenId)
                .orElseThrow(() ->
                        new RuntimeException("Screen not found"));

        return seatRepository.save(seat);
    }

    @Override
    public List<Seat> getSeat() {
        return seatRepository.findAll();
    }

    @Override
    public Seat getSeatById(Long id) {
        return seatRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Seat not found"));
    }

    @Override
    public List<Seat> getSeatByScreenId(Long screenId) {
        return seatRepository.findByScreenId(screenId);
    }
}
