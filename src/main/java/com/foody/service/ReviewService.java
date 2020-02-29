package com.foody.service;

import com.foody.entity.City;
import com.foody.entity.Review;
import com.foody.repository.CityRepository;
import com.foody.repository.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ReviewService {
    List<Review> getAllReviews();
    List<Review> getReviewByRestaurant(int id);
    Review deleteReviews(int id);
    Review updateReviews(int id);
    Review addReviews();


    }
