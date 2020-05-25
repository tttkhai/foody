package com.foody.service;

import com.foody.entity.User;
import com.foody.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class JwtUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder bcryptEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) {
        User user = userRepository.findUserByUserName(username);
        System.out.println("this is user "+ (user==null));
        if (user == null) {
            throw new UsernameNotFoundException("User not found with username: " + username);
        }
        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(),
                new ArrayList<>());
    }

    public User save(User user) {
        user.setPassword(bcryptEncoder.encode(user.getPassword()));
        return userRepository.save(user);
    }

    public User getUser(int id) {
        return userRepository.findById(id).map(user->{
            return user;
        }).orElseThrow(()->new ResourceNotFoundException("User Id  " + id + " not found"));
    }

    public User deleteUser(int id) {
        return userRepository.findById(id).map(user -> {
            return user;
        }).orElseThrow(()-> new ResourceNotFoundException("there is no user with this id "+ id));
    }

    public User updateUser(int id, User user) {
        return userRepository.findById(id).map(u -> {
            user.setId(u.getId());
            user.setPassword(bcryptEncoder.encode(user.getPassword()));
            return userRepository.save(user);
        }).orElseThrow(()-> new ResourceNotFoundException("there is no user with this id "+ id));
    }
}
