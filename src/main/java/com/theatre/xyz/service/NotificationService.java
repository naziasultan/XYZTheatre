package com.theatre.xyz.service;

import com.theatre.xyz.model.Booking;

public interface NotificationService {
    void sendBookingConfirmation(Booking booking);
}
