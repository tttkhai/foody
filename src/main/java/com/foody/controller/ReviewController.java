package com.foody.controller;

import com.foody.entity.Review;
import com.foody.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ReviewController {
    @Autowired
    private ReviewService reviewService;

    @PostMapping(value = "/newReview")
    public Review createReview(@RequestBody Review review)
    {
        System.out.println("This is review: "+review);
//        return reviewService.addReviews(review);
        return null;
    }

    @PutMapping(value = "/review/{id}")
    public ResponseEntity<?> updateReviews(@PathVariable int id, @RequestBody Review review) {
        return ResponseEntity.ok().body(reviewService.updateReviews(id, review));
    }

    @DeleteMapping(value = "/review/{id}")
    public ResponseEntity<?> deleteReviews(@PathVariable int id) {
        reviewService.deleteReviews(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping(value = "/reviews/{restaurant_id}")
    public ResponseEntity<?> getReviewsByRestaurant(@PathVariable int restaurant_id) {
        List<Review> reviews = reviewService.getReviewByRestaurant(restaurant_id);
        return ResponseEntity.ok().body(reviews);
    }

}
