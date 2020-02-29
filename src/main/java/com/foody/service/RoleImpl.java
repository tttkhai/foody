package com.foody.service;

import com.foody.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleImpl {

    @Autowired
    private RoleRepository roleRepository;


}
