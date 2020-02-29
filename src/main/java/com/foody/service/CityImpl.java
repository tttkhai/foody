package com.foody.service;

import com.foody.repository.CityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CityImpl {

    @Autowired
    private CityRepository cityRepository;


}
