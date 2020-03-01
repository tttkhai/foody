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
        }).orElseThrow(()->new ResourceNotFoundException("User Id  " + id + " not found"));
    }

    @Override
    public User addUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public User deleteUser(int id) {
        return userRepository.findById(id).map(user -> {
            return user;
        }).orElseThrow(()-> new ResourceNotFoundException("there is no user with this id "+ id));
    }

    @Override
    public User updateUser(int id, User user) {
        return userRepository.findById(id).map(u -> {
            user.setId(u.getId());
            return userRepository.save(user);
        }).orElseThrow(()-> new ResourceNotFoundException("there is no user with this id "+ id));
    }
}
