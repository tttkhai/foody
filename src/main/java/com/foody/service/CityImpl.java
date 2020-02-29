package com.foody.service;

import com.foody.entity.City;
import com.foody.repository.CityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CityImpl implements CityService{

    @Autowired
    private CityRepository cityRepository;

    @Override
    public List<City> getCityByState(int stateId) {
        return cityRepository.getCityByState(stateId);
    }

}
