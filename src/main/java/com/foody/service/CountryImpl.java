package com.foody.service;

import com.foody.repository.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CountryImpl {

    @Autowired
    private CountryRepository countryRepository;


}
