package com.foody.service;

import com.foody.entity.Country;
import com.foody.entity.Role;
import com.foody.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RoleImpl implements RoleService{

    @Autowired
    private RoleRepository roleRepository;


    @Override
    public List<Role> getAllRoles() {
        List<Role> roleList= new ArrayList<>();
        roleRepository.findAll().forEach(roleList::add);
        return roleList;
    }
}
