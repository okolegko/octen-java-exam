package com.autoria.service;

import lombok.RequiredArgsConstructor;
import octen.java.com.autoria.model.Listing;
import octen.java.com.autoria.repository.ListingRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ListingService {

    private final ListingRepository listingRepository;

    public Listing save(Listing listing) {
        return listingRepository.save(listing);
    }

    public Optional<Listing> findById(Long id) {
        return listingRepository.findById(id);
    }

    public void incrementViews(Long id) {
        listingRepository.findById(id).ifPresent(listing -> {
            listing.setViews(listing.getViews() + 1);
            listingRepository.save(listing);
        });
    }
}
