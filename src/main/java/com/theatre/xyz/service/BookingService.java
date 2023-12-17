package com.theatre.xyz.service;

import com.theatre.xyz.model.Booking;

import java.time.LocalDateTime;

public interface BookingService {
   // void processBooking(Booking booking);

    void lockSeats(String bookingId, int numberOfSeats, LocalDateTime lockingExpiryTime);

    boolean isSeatsAvailable(String bookingId);
}
