package com.theatre.xyz.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.Collection;

@Data
@Entity
@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class Theatre {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @ManyToOne
    @JoinColumn(name = "city_id")
    private City city;

    private int capacity;

    @JsonIgnore
    @OneToMany(mappedBy = "theatre")
    private Collection<Booking> booking;

    @ManyToOne
    @JoinColumn(name = "movie_id")
    private Movie movie;
}
