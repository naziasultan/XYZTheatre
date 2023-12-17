package com.theatre.xyz.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Data
@Entity
public class Movie {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;
    private String title;
    private String language;
    private String genre;
    
    @DateTimeFormat(pattern = "dd-MM-yyyy HH:mm")
    private LocalDateTime dateTime;

    @JsonIgnore  // Add this annotation to ignore the theatres field during serialization and deserialization
    @OneToMany(mappedBy = "movie")
    private List<Theatre> theatres;

    @ManyToOne
    @JoinColumn(name = "city_id")
    private City city;
}
