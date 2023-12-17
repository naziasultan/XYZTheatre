package com.theatre.xyz.service.impl;

import com.theatre.xyz.model.Offer;
import com.theatre.xyz.repository.OfferRepository;
import com.theatre.xyz.service.OfferService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class OfferServiceImpl implements OfferService {

    private final OfferRepository offerRepository;

    @Override
    public List<Offer> getAllOffers() {
        return offerRepository.findAll();
    }

    @Override
    public List<Offer> addOffers(List<Offer> offers) {
        return offerRepository.saveAll(offers);
    }

}
