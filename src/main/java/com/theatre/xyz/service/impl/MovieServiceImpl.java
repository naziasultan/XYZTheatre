package com.theatre.xyz.service.impl;

import com.theatre.xyz.model.Movie;
import com.theatre.xyz.repository.MovieRepository;
import com.theatre.xyz.service.MovieService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class MovieServiceImpl implements MovieService {
    private final MovieRepository movieRepository;

    public List<Movie> getAllMovies() {
        return movieRepository.findAll();
    }

    public Movie addMovie(Movie movie) {
        // You may want to validate the movie data before saving it to the database
        return movieRepository.save(movie);
    }

    public List<Movie> getMoviesByCity(Long cityId) {
        return movieRepository.findByCityId(cityId);
    }

}
