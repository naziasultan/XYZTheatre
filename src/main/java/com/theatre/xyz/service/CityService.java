package com.theatre.xyz.service;

import com.theatre.xyz.model.City;

import java.util.List;

public interface CityService {
    List<City> getAllCities();

    List<City> addCities(List<City> cities);
}
