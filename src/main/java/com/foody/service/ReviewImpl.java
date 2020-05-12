package com.foody.service;

import com.foody.entity.*;
import com.foody.repository.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ReviewImpl implements ReviewService{

    @Autowired
    private ReviewRepository reviewRepository;

    @Autowired
    private JwtUserDetailsService userService;

    @Autowired
    private RestaurantService restaurantService;

    @Override
    public List<Review> getReviewByRestaurant(int id) {
        return reviewRepository.reviewsByRestaurant(id);
    }

    @Override
    public Review deleteReviews(int id) {
        return reviewRepository.findById(id).map(review -> {
            return review;
        }).orElseThrow(()-> new ResourceNotFoundException("there is no review with this id "+ id));
    }

    @Override
    public Review updateReviews(int id, Review review) {
        return reviewRepository.findById(id).map(r -> {
            review.setId(r.getId());
            return reviewRepository.save(review);
        }).orElseThrow(()-> new ResourceNotFoundException("there is no review with this id "+ id));
    }

    @Override
    public Review addReviews(Review review) {
        User user= userService.getUser(review.getUser().getId());
        Restaurant restaurant = restaurantService.restaurantById(review.getRestaurant().getId());
        review.setUser(user);
        review.setRestaurant(restaurant);
        return reviewRepository.save(review);
    }

}
