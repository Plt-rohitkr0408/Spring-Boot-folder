package com.example.MovieDekho.service;

import com.example.MovieDekho.entity.Show;
import com.example.MovieDekho.respository.MovieRepository;
import com.example.MovieDekho.respository.ScreenRepository;
import com.example.MovieDekho.respository.ShowRepository;
import com.example.MovieDekho.service.intface.ShowServiceInterface;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ShowService  implements ShowServiceInterface {

    private final ShowRepository showRepository;
    private final ScreenService screenService;
    private final MovieService movieService;

    @Override
    public Show addShow(Show show) {
        return showRepository.save(show);
    }

    @Override
    public Show getShowById(Long id) {
        return showRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Show not found"));
    }

    @Override
    public List<Show> getAllShow() {
        return showRepository.findAll();
    }

    @Override
    public List<Show> getShowByScreenId(Long screenId) {
        return showRepository.findByScreenId(screenId);
    }

    @Override
    public List<Show> getShowByMovieId(Long movieId) {
        return showRepository.findByMovieId(movieId);
    }

    @Override
    public List<Show> getShowByMovieAndDate(Long movieId, LocalDate showDate) {
        return showRepository.findByMovieIdAndShowDate(movieId,showDate);
    }
}
