package com.foody.service;

import com.foody.entity.User;
import com.foody.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserImpl implements UserService{

    @Autowired
    private UserRepository userRepository;


    @Override
    public User getUser(int id) {
        return userRepository.findById(id).map(res->{
            return res;
        }).orElseThrow(()->new ResourceNotFoundException("Restaurant Id  " + id + " not found"));
    }

    @Override
    public User addUser(User user) {
        return null;
    }

    @Override
    public User deleteUser(int id) {
        return null;
    }

    @Override
    public User updateUser(int id) {
        return null;
    }
}
