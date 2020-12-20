package com.foody.service;

import com.foody.entity.Review;

import org.json.JSONException;

import java.util.List;
import java.util.Map;

public interface ReviewService {
    List<Review> getReviewByRestaurant(int id);
    Review deleteReviews(int id);
    Review updateReviews(int id, Review review);
    Review addReview(Map<String, Object> payload) throws JSONException;

}
