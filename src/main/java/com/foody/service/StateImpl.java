package com.foody.service;

import com.foody.repository.StateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StateImpl {

    @Autowired
    private StateRepository stateRepository;


}
