package com.foody.service;

import com.foody.entity.City;
import com.foody.entity.Country;
import com.foody.repository.CityRepository;
import com.foody.repository.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

public interface CountryService {
    List<Country> getAllCountry();

}
