package com.theatre.xyz.controller;

import com.theatre.xyz.model.City;
import com.theatre.xyz.service.CityService;
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
@RequestMapping("/api/city")
public class CityController {
    private final CityService cityService;

    @PostMapping("/city")
    public ResponseEntity<List<City>> addCity(@RequestBody List<City> cities) {
        // You may want to add validation logic here before adding the movie
        List<City> addedCity = cityService.addCities(cities);
        return new ResponseEntity<>(addedCity, HttpStatus.CREATED);
    }

    @GetMapping("/cities")
    public ResponseEntity<List<City>> getAllCities() {
        List<City> cities = cityService.getAllCities();
        return new ResponseEntity<>(cities, HttpStatus.OK);
    }

}
