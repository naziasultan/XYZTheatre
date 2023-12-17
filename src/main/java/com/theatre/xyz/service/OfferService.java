package com.theatre.xyz.service;

import com.theatre.xyz.model.Offer;

import java.util.List;

public interface OfferService {
    List<Offer> getAllOffers();

    List<Offer> addOffers(List<Offer> offers);
}
