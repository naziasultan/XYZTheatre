package com.theatre.xyz.model;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Data
@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private double totalAmount;

    @ManyToOne
    @JoinColumn(name = "theatre_id")
    private Theatre theatre;

    private int numberOfSeats;
    private LocalDateTime startTime;
    private LocalDateTime lockingExpiryTime;

    // Define relationships with Movie, Theatre, and User entities
}
