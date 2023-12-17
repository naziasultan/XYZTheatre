package com.theatre.xyz.service;

import com.theatre.xyz.model.Movie;

import java.util.List;

public interface SearchService {

    List<Movie> searchMoviesByTitle(String title);
}
