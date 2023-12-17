package com.theatre.xyz.service.impl;

import com.theatre.xyz.model.City;
import com.theatre.xyz.repository.CityRepository;
import com.theatre.xyz.service.CityService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class CityServiceImpl implements CityService {
    private final CityRepository cityRepository;

    public List<City> getAllCities() {
        return cityRepository.findAll();
    }


    public City addCity(City city) {
        return cityRepository.saveAndFlush(city);
    }
}
