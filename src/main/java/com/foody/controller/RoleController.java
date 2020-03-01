package com.foody.controller;

import com.foody.entity.State;
import com.foody.service.RoleImpl;
import com.foody.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
