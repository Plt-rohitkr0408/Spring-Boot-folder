package com.example.MovieDekho.service;

import com.example.MovieDekho.entity.Theater;
import com.example.MovieDekho.respository.CityRepository;
import com.example.MovieDekho.respository.TheaterRepository;
import com.example.MovieDekho.service.intface.TheaterServiceInterface;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TheaterService implements TheaterServiceInterface {

    private final TheaterRepository theaterRepository;
    private final CityRepository cityRepository;

    @Override
    public Theater addTheater(Theater theater) {

        if(theater.getCity() == null){
            throw new RuntimeException(
                    "City is required");
        }
        Long cityId = theater.getCity().getId();
        cityRepository.findById(cityId)
                .orElseThrow(() ->
                        new RuntimeException("City not found"));

        return theaterRepository.save(theater);
    }

    @Override
    public List<Theater> getTheaters() {
        return theaterRepository.findAll();
    }

    @Override
    public Theater getTheaterById(Long id) {
        return theaterRepository.findById(id).orElseThrow(() -> new RuntimeException("User not found"));
    }

    @Override
    public List<Theater> getTheaterByCityId(Long cityId) {

        List<Theater> theaters =
                theaterRepository.findByCityId(cityId);

        if(theaters.isEmpty()){
            throw new RuntimeException(
                    "No theaters found for this city");
        }

        return theaters;
    }


}
