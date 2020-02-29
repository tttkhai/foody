package com.foody.service;

import com.foody.entity.Country;
import com.foody.entity.Role;
import com.foody.repository.CityRepository;
import com.foody.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface RoleService {
    List<Role> getAllRoles();


}
