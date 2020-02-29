package com.foody.service;

import com.foody.entity.City;
import com.foody.entity.Review;
import com.foody.repository.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

public class ReviewImpl implements ReviewService{

    @Autowired
    private ReviewRepository reviewRepository;

    @Override
    public List<Review> getAllReviews() {
        return null;
    }

    @Override
    public List<Review> getReviewByRestaurant(int id) {
        return null;
    }

    @Override
    public Review deleteReviews(int id) {
        return null;
    }

    @Override
    public Review updateReviews(int id) {
        return null;
    }

    @Override
    public Review addReviews() {
        return null;
    }
}
