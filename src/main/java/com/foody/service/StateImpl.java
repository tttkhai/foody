package com.foody.service;

import com.foody.entity.State;
import com.foody.repository.StateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StateImpl implements StateService{

    @Autowired
    private StateRepository stateRepository;

    @Override
    public List<State> getStateByCountry(int countryId) {
        return stateRepository.getStateByCountry(countryId);
    }
}
