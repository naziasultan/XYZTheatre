package com.theatre.xyz.service.impl;

import com.theatre.xyz.model.City;
import com.theatre.xyz.model.Theatre;
import com.theatre.xyz.repository.TheatreRepository;
import com.theatre.xyz.service.TheatreService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class TheatreServiceImpl implements TheatreService {
    private final TheatreRepository theatreRepository;

    public List<Theatre> getAllTheatres() {
        return theatreRepository.findAll();
    }

    public List<Theatre> getTheatresByCity(City city) {
        return theatreRepository.findByCity(city);
    }

    public Theatre addTheatre(Theatre theatre) {
        return theatreRepository.save(theatre);
    }

    public List<Theatre> getListOfTheatresByMovieIdAndDateTime(Long movieId, LocalDateTime dateTime) {

        return theatreRepository.getListOfTheatresByMovieIdAndMovieDateTime(movieId, dateTime);
    }

}
