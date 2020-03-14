package com.foody.controller;


import com.foody.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class RoleController {
    @Autowired
    private RoleService roleService;

    @GetMapping(value = "/roles")
    public ResponseEntity<?> getAllRoles() {
        return ResponseEntity.ok().body(roleService.getAllRoles());
    }
}
