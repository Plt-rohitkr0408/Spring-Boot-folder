package com.example.MovieDekho.service;

import com.example.MovieDekho.entity.City;
import com.example.MovieDekho.respository.CityRepository;
import com.example.MovieDekho.service.intface.CityServiceInterface;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CityService implements CityServiceInterface {

    private final CityRepository cityRepository;


    public City getCityById(Long id) {
        return cityRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("City not found"));
    }

    @Override
    public List<City> getAllCity() {
        return cityRepository.findAll();
    }

    @Override
    public City getCityByName(String cityName) {

        return cityRepository.findByCityName(cityName);

    }
    @Override
    public City addCity(City city) {
        return cityRepository.save(city);
    }

    @Override
    public List<City> getCityByState(String state) {

        List<City> cities =
                cityRepository.findByState(state);

        if(cities.isEmpty()){
            throw new RuntimeException(
                    "No cities found");
        }

        return cities;
    }
}
