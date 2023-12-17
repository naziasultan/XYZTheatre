package com.theatre.xyz.controller;

import com.theatre.xyz.model.City;
import com.theatre.xyz.model.Theatre;
import com.theatre.xyz.service.TheatreService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
@RequestMapping("/api/theatres")
public class TheatreController {
    private final TheatreService theatreService;

    @PostMapping("/queryByCity")
    public ResponseEntity<List<Theatre>> getTheatresByCity(@RequestBody City city) {
        List<Theatre> theatres = theatreService.getTheatresByCity(city);
        return new ResponseEntity<>(theatres, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Theatre> addTheatre(@RequestBody Theatre theatre) {
        Theatre savedTheatre = theatreService.addTheatre(theatre);
        return new ResponseEntity<>(savedTheatre, HttpStatus.CREATED);
    }

    @GetMapping("/theatres/{movieId}")
    public ResponseEntity<List<Theatre>> getListOfTheatresByMovieIdAndDateTime(
            @PathVariable Long movieId,
            @RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss.SSS") LocalDateTime dateTime
    ) {
        List<Theatre> theatreList = theatreService.getListOfTheatresByMovieIdAndDateTime(movieId, dateTime);
        return new ResponseEntity<>(theatreList, HttpStatus.OK);
    }

}
