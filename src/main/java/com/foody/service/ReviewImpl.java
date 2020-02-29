package com.foody.service;

import com.foody.repository.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReviewImpl {

    @Autowired
    private ReviewRepository reviewRepository;


}
