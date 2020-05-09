package com.foody.service;

import com.foody.entity.User;
import com.foody.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

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
