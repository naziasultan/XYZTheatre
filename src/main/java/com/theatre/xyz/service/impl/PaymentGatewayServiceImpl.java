package com.theatre.xyz.service.impl;

import com.theatre.xyz.model.Booking;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class PaymentGatewayServiceImpl {
    public void processPayment(Booking booking) {
        // Implement payment processing logic
        // For example, connect to a payment gateway and execute the transaction
    }
}
