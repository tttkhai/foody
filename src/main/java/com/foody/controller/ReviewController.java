package com.foody.controller;

import com.foody.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class ReviewController {
    @Autowired
    private ReviewService reviewService;
}
