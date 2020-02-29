package com.foody.service;

import com.foody.entity.State;

import java.util.List;

public interface StateService {

    List<State> getStateByCountry(int countryId);



}
