package com.jit.rating.service.controllers;

import com.jit.rating.service.entities.Rating;
import com.jit.rating.service.services.RatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ratings")
public class RatingController {

    private RatingService ratingService;

    @Autowired
    public RatingController(RatingService ratingService) {
        this.ratingService = ratingService;
    }

    //to create a rating
    @PostMapping
    public ResponseEntity<Rating> crateRating(@RequestBody Rating rating) {
        Rating createdRating = ratingService.saveRating(rating);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdRating);
    }

    //get all ratings
    @GetMapping
    public ResponseEntity<List<Rating>> getRatings() {
        List<Rating> fetchedRatings = ratingService.getRatings();
        return ResponseEntity.ok(fetchedRatings);
    }

    //to fetch all ratings of a specific user
    @GetMapping("/users/{userId}")
    public ResponseEntity<List<Rating>> getAllRatingOfSpecificUser(@PathVariable String userId) {
        List<Rating> fetchedRatings = ratingService.getRatingsByUserId(userId);
        return ResponseEntity.ok(fetchedRatings);
    }

    //to fetch all ratings of a specific hotel
    @GetMapping("/hotels/{hotelId}")
    public ResponseEntity<List<Rating>> getAllRatingOfSpecificHotel(@PathVariable String hotelId) {
        List<Rating> fetchedRatings = ratingService.getRatings(hotelId);
        return ResponseEntity.ok(fetchedRatings);
    }
}
