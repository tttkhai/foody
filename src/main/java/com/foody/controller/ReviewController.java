package com.foody.controller;

import com.foody.entity.Restaurant;
import com.foody.entity.Review;
import com.foody.repository.ReviewRepository;
import com.foody.service.CityService;
import com.foody.service.RestaurantTypeImpl;
import com.foody.service.ReviewImpl;
import com.foody.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ReviewController {
    @Autowired
    private ReviewService reviewService;

    @PostMapping(value = "/addReview")
    public Review createReview(@RequestBody Review review) {
        return reviewService.addReviews(review);
    }

    @PutMapping(value = "/updateReview/{id}")
    public ResponseEntity<?> updateReviews(@PathVariable int id, @RequestBody Review review) {
        return ResponseEntity.ok().body(reviewService.updateReviews(id, review));
    }

    @DeleteMapping(value = "/deleteReview/{id}")
    public ResponseEntity<?> deleteReviews(@PathVariable int id) {
        reviewService.deleteReviews(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping(value = "/reviews/restaurant={res_id}")
    public ResponseEntity<?> getReviewsByRestaurant(@RequestParam int res_id) {
        List<Review> reviews = reviewService.getReviewByRestaurant(res_id);
        return ResponseEntity.ok().body(reviews);
    }

}
