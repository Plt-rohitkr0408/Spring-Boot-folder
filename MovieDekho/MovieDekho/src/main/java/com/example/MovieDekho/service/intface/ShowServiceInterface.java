package com.example.MovieDekho.service.intface;

import com.example.MovieDekho.entity.Show;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

public interface ShowServiceInterface {

    Show addShow(Show show);
    Show getShowById(Long id);
    List<Show> getAllShow();
    List<Show> getShowByScreenId(Long screenId);
    List<Show> getShowByMovieId(Long movieId);
    List<Show> getShowByMovieAndDate(Long movieId, LocalDate showDate);

}
