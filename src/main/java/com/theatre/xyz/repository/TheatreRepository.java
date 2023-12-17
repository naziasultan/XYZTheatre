package com.theatre.xyz.repository;

import com.theatre.xyz.model.City;
import com.theatre.xyz.model.Theatre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface TheatreRepository extends JpaRepository<Theatre, Long> {
    // You can define custom queries here if needed
    List<Theatre> findByCity(City city);

    List<Theatre> getListOfTheatresByMovieIdAndMovieDateTime(Long id, LocalDateTime dateTime);
}
