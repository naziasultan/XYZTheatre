package com.theatre.xyz.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class BookingRequest {
    private String bookingId;
    private int numberOfSeats;
}
