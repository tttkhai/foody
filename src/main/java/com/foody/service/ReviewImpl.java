package com.foody.service;

import com.foody.entity.*;
import com.foody.repository.ReviewRepository;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

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
    public Review addReview(Map<String, Object> review) throws JSONException {
        JSONObject json = new JSONObject(review);
        int cleanliness = json.getInt("cleanliness");
        int customer_service = json.getInt("customer_service");
        int taste = json.getInt("taste");
        int deliver = json.getInt("deliver");
        String comment = json.getString("comment");
        int restaurant_id = json.getInt("restaurant_id");
        int user_id = json.getInt("user_id");
        return reviewRepository.addReview(cleanliness, customer_service, deliver, taste, comment, restaurant_id, user_id);
    }

}
