package com.theatre.xyz.service.impl;

import com.theatre.xyz.model.Movie;
import com.theatre.xyz.repository.MovieRepository;
import com.theatre.xyz.service.SearchService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Slf4j
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
@Service
public class SearchServiceImpl implements SearchService {

    @Value("${search-elasticsearch-service}")
    private String movieApiUrl; // assuming this is search-elasticSearch endpoint
    private final RestTemplate restTemplate;

    public List<Movie> searchMoviesByTitle(String title) {
        // Make an API call to retrieve movies by title
        Movie[] movies = restTemplate.getForObject(movieApiUrl + "/search?title=" + title, Movie[].class);
        log.info("Successful Results for {}",title);

        if (movies != null) {
            return Arrays.asList(movies);
        }

        return List.of();
    }


}
