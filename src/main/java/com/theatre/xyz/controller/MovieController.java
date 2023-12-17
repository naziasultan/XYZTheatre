package com.theatre.xyz.controller;

import com.theatre.xyz.model.Movie;
import com.theatre.xyz.service.MovieService;
import com.theatre.xyz.service.SearchService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
@RequestMapping("/api/movies")
public class MovieController {
    private final MovieService movieService;
    private final SearchService searchService;

    @GetMapping("/all")
    public ResponseEntity<List<Movie>> getAllMovies() {
        List<Movie> movies = movieService.getAllMovies();
        return new ResponseEntity<>(movies, HttpStatus.OK);
    }

    @PostMapping("/movie")
    public ResponseEntity<Movie> addMovie(@RequestBody Movie movie) {
        // You may want to add validation logic here before adding the movie
        Movie addedMovie = movieService.addMovie(movie);
        return new ResponseEntity<>(addedMovie, HttpStatus.CREATED);
    }

    @GetMapping("/byCity/{cityId}")
    public ResponseEntity<List<Movie>> getMoviesByCity(@PathVariable Long cityId) {
        List<Movie> movies = movieService.getMoviesByCity(cityId);
        return new ResponseEntity<>(movies, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<Movie>> searchMovies(@RequestParam String title) {
        List<Movie> searchResults = searchService.searchMoviesByTitle(title);

        if (!searchResults.isEmpty()) {
            return new ResponseEntity<>(searchResults, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

}
