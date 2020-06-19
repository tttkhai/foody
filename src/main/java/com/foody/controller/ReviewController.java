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
    public Review createReview(@RequestBody Review review) {
        return reviewService.addReviews(review);
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

    @GetMapping(value = "/reviews")
    public ResponseEntity<?> getReviewsByRestaurant(@RequestParam(name="restaurant") int id) {
        List<Review> reviews = reviewService.getReviewByRestaurant(id);
        return ResponseEntity.ok().body(reviews);
    }

}
