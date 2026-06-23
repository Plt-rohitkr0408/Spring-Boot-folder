package com.example.MovieDekho.service.intface;

import com.example.MovieDekho.entity.Screen;

import java.util.List;

public interface ScreensServiceInterface {
    Screen addScreen(Screen screen);
    List<Screen> getScreens();
    Screen getScreenById(Long id);

    List<Screen> getScreensByTheaterId(Long theaterId);
}
