package com.foody.controller;

import com.foody.entity.Review;
import com.foody.service.ReviewService;
import org.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Map;

@RestController
public class ReviewController {
    @Autowired
    private ReviewService reviewService;

    @PostMapping(value = "/newReview")
    public ResponseEntity<?> createReview(@Valid @RequestBody Map<String, Object> payload) throws JSONException
    {
        try
        {
            Review review = reviewService.addReview(payload);
            return ResponseEntity.ok(review);
        } catch(Exception e)
        {
            return ResponseEntity.status(400).body(e.toString());
        }
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
