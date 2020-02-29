package com.foody.service;

import com.foody.entity.City;
import com.foody.entity.Country;
import com.foody.repository.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CountryImpl implements CountryService{

    @Autowired
    private CountryRepository countryRepository;

    @Override
    public List<Country> getAllCountry() {
        List<Country> countryList= new ArrayList<>();
        countryRepository.findAll().forEach(countryList::add);
        return countryList;
    }


}
