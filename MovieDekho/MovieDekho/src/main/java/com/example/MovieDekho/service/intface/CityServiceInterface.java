package com.example.MovieDekho.service.intface;

import com.example.MovieDekho.entity.City;

import java.util.List;

public interface CityServiceInterface {
    List<City> getAllCity();
    City getCityByName(String name);
    City addCity(City city);
    List<City> getCityByState(String state);
}
