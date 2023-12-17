package com.theatre.xyz.repository;

import com.theatre.xyz.model.City;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CityRepository extends JpaRepository<City, Long> {

    // Other repository methods can be added based on requirements
}
