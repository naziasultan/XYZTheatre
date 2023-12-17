package com.theatre.xyz.service;

import com.theatre.xyz.model.City;

import java.util.List;

public interface CityService {
    List<City> getAllCities();
    City addCity(City city);
}
