package com.foody.service;

import com.foody.repository.CityRepository;
import com.foody.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

public interface UserService {

    List<user> getUser();


}
