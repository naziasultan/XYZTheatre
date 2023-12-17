package com.theatre.xyz.controller;

import com.theatre.xyz.model.BookingRequest;
import com.theatre.xyz.service.BookingService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/api/tickets")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class TicketBookingController {

    private final BookingService bookingService;

    @PostMapping("/book")
    public ResponseEntity<String> bookTickets(@RequestBody BookingRequest bookingRequest) {
        String bookingId = bookingRequest.getBookingId();
        int numberOfSeats = bookingRequest.getNumberOfSeats();
        LocalDateTime lockingExpiryTime = calculateLockingExpiryTime();

        // Lock seats for the specified booking
        bookingService.lockSeats(bookingId, numberOfSeats, lockingExpiryTime);

        // Perform other booking-related logic, such as updating the database with the booked seats

        return new ResponseEntity<>("Seats booked successfully", HttpStatus.OK);
    }

    @GetMapping("/checkAvailability/{bookingId}")
    public ResponseEntity<String> checkSeatAvailability(@PathVariable String bookingId) {
        // Check if seats associated with the booking ID are still available
        boolean seatsAvailable = bookingService.isSeatsAvailable(bookingId);

        if (seatsAvailable) {
            return new ResponseEntity<>("Seats are available", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Seats are not available or the lock has expired", HttpStatus.BAD_REQUEST);
        }
    }

    private LocalDateTime calculateLockingExpiryTime() {
        // Implement logic to calculate the locking expiry time, e.g., add a fixed duration to the current time
        return LocalDateTime.now().plusMinutes(30);
    }
}
