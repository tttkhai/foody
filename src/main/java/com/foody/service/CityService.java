package com.foody.service;

import com.foody.entity.City;
import com.foody.repository.CityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

public interface CityService {
    List<City> getCityByState(int stateId);


}
