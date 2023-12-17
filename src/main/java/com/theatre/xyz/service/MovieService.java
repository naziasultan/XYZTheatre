package com.theatre.xyz.service;

import com.theatre.xyz.model.Movie;

import java.util.List;

public interface MovieService {
    List<Movie> getAllMovies();
    Movie addMovie(Movie movie);
    List<Movie> getMoviesByCity(Long cityId);
}
