package com.theatre.xyz.controller;

import com.theatre.xyz.model.Offer;
import com.theatre.xyz.service.OfferService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Slf4j
@RestController
@RequestMapping("/api/offers")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class OfferController {
    private final OfferService offerService;

    @PostMapping
    public ResponseEntity<List<Offer>> addOffers(@RequestBody List<Offer> offers) {
        List<Offer> offerResponse = offerService.addOffers(offers);
        return new ResponseEntity<>(offerResponse, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<Offer>> getOffers() {
        List<Offer> offers = offerService.getAllOffers();
        return new ResponseEntity<>(offers, HttpStatus.OK);
    }

    // Other endpoints can be added based on requirements

    @GetMapping("/applyDiscount/{totalTickets}/{pricePerTicket}")
    public ResponseEntity<Double> applyDiscount(@PathVariable int totalTickets, @PathVariable double pricePerTicket) {
        // Assume the offer with priority 1 is the 50% discount on the 3rd ticket
        Optional<Offer> thirdTicketDiscountOffer = offerService.getAllOffers()
                .stream()
                .filter(offer -> offer.getPriority() == 1)
                .findFirst();

        double totalAmount = totalTickets * pricePerTicket;

        if (thirdTicketDiscountOffer.isPresent() && totalTickets >= 3) {
            int discountedTickets = totalTickets / 3;
            double discountAmount = discountedTickets * 0.5 * pricePerTicket;
            totalAmount -= discountAmount;
        }

        return new ResponseEntity<>(totalAmount, HttpStatus.OK);
    }

    @GetMapping("/applyDiscountOnAfternoonShow/{totalAmount}")
    public ResponseEntity<Double> applyDiscountOnAfternoonShow(@PathVariable double totalAmount) {
        // Assume the offer with priority 2 is the 20% discount on afternoon shows
        Optional<Offer> afternoonShowDiscountOffer = offerService.getAllOffers()
                .stream()
                .filter(offer -> offer.getPriority() == 2)
                .findFirst();

        if (afternoonShowDiscountOffer.isPresent()) {
            // Apply the dynamic offer using a lambda function or update the formula in the database
            totalAmount = totalAmount * 0.8; // 20% discount
        }

        return new ResponseEntity<>(totalAmount, HttpStatus.OK);
    }
}
