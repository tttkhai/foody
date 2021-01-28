package com.foody.service;

import com.foody.entity.Role;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface RoleService {
    List<Role> getAllRoles();


}
