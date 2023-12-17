package com.theatre.xyz.service;

import com.theatre.xyz.model.City;
import com.theatre.xyz.model.Theatre;

import java.time.LocalDateTime;
import java.util.List;

public interface TheatreService {
    List<Theatre> getAllTheatres();

    List<Theatre> getTheatresByCity(City city);

    Theatre addTheatre(Theatre theatre);

    List<Theatre> getListOfTheatresByMovieIdAndDateTime(Long movieId, LocalDateTime dateTime);

}
