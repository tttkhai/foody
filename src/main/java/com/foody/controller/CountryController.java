package com.foody.controller;

import com.foody.service.CountryImpl;
import com.foody.service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class CountryController {
    @Autowired
    private CountryImpl countryImpl;
}
