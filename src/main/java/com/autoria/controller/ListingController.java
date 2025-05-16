package com.autoria.controller;

import com.autoria.dto.ListingRequest;
import com.autoria.model.Listing;
import com.autoria.service.ListingService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/listings")
@RequiredArgsConstructor
public class ListingController {

    private final ListingService listingService;

    @PostMapping
    public ResponseEntity<Listing> createListing(@RequestBody @Valid ListingRequest request,
                                                 @AuthenticationPrincipal String username) {
        Listing listing = listingService.createListing(request, username);
        return ResponseEntity.ok(listing);
    }

    @GetMapping("/{id}/statistics")
    public ResponseEntity<?> getStatistics(@PathVariable Long id,
                                           @AuthenticationPrincipal String username) {
        return ResponseEntity.ok(listingService.getStatistics(id, username));
    }
}
