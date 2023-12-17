package com.theatre.xyz.service;

import com.theatre.xyz.model.Booking;

public interface SeatLockingService {
    void lockSeats(Booking booking);
}
