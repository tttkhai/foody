package com.foody.controller;

import com.foody.repository.ReviewRepository;
import com.foody.service.CityService;
import com.foody.service.RestaurantTypeImpl;
import com.foody.service.ReviewImpl;
import com.foody.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ReviewController {
    @Autowired
    private ReviewService reviewService;
}
