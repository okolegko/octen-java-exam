package com.autoria.util;

import octen.java.com.autoria.dto.ListingRequest;
import octen.java.com.autoria.model.Brand;
import octen.java.com.autoria.model.Listing;
import octen.java.com.autoria.model.Model;
import octen.java.com.autoria.model.User;

public class ListingMapper {

    public static Listing fromRequest(ListingRequest request, Brand brand, Model model, User user) {
        Listing listing = new Listing();
        listing.setBrand(brand);
        listing.setModel(model);
        listing.setDescription(request.getDescription());
        listing.setCurrency(request.getCurrency());
        listing.setPrice(request.getPrice());
        listing.setUser(user);
        listing.setViews(0);
        return listing;
    }
}
