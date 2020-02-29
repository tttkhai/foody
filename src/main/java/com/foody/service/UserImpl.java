package com.foody.service;

import com.foody.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserImpl {

    @Autowired
    private UserRepository userRepository;


}
