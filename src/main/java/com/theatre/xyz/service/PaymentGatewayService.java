package com.theatre.xyz.service;

import com.theatre.xyz.model.Booking;

public interface PaymentGatewayService {
    void processPayment(Booking booking);
}
