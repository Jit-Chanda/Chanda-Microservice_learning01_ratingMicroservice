package com.jit.rating.service.services;

import com.jit.rating.service.entities.Rating;

import java.util.List;

public interface RatingService {

    //to create rating
    Rating saveRating(Rating rating);

    //to get all ratings
    List<Rating> getRatings();

    //get single rating by specific ratingId
    List<Rating> getRatings(String hotelId);

    //get a specific user's all rating
    List<Rating> getRatingsByUserId(String userId);
}
