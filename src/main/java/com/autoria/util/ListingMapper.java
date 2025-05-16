package com.autoria.util;

import octen.java.exam.dto.ListingRequest;
import octen.java.exam.model.Brand;
import octen.java.exam.model.Listing;
import octen.java.exam.model.Model;
import octen.java.exam.model.User;

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
