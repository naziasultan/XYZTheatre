package com.theatre.xyz.service.impl;

import com.theatre.xyz.model.Booking;
import com.theatre.xyz.model.Offer;
import com.theatre.xyz.service.BookingService;
import com.theatre.xyz.service.OfferService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.LinkedHashMap;
import java.util.Map;

@Slf4j
@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class BookingServiceImpl implements BookingService {
    private final Map<String, Booking> temporaryBookings = new LinkedHashMap<>();

    public void lockSeats(String bookingId, int numberOfSeats, LocalDateTime lockingExpiryTime) {

        Booking bookingDetails = Booking.builder()
                .numberOfSeats(numberOfSeats)
                .startTime(LocalDateTime.now())
                .lockingExpiryTime(lockingExpiryTime).build();

        temporaryBookings.put(bookingId, bookingDetails);
        log.info("Booking {} Successfully updated", bookingId);
    }

    public boolean isSeatsAvailable(String bookingId) {
        if (temporaryBookings.containsKey(bookingId)) {
            Booking bookingDetails = temporaryBookings.get(bookingId);
            log.info("BookingDetails Successfully retrieved for bookingId {} ", bookingId);
            LocalDateTime currentTime = LocalDateTime.now();
            return currentTime.isBefore(bookingDetails.getLockingExpiryTime());
        }
        return false;
    }
}

