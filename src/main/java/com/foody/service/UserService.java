package com.foody.service;

import com.foody.entity.User;
import com.foody.repository.CityRepository;
import com.foody.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

public interface UserService {

    User getUser(int id);
    User deleteUser(int id);
    User updateUser(int id, User user);
//    User addUser(User user);
}
