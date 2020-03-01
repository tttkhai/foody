package com.foody.service;

import com.foody.entity.Review;

import org.springframework.stereotype.Service;

import java.util.List;

public interface ReviewService {
    List<Review> getReviewByRestaurant(int id);
    Review deleteReviews(int id);
    Review updateReviews(int id, Review review);
    Review addReviews(Review review);

}
