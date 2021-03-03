package com.foody.controller;


import com.foody.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RoleController {
    @Autowired
    private RoleService roleService;

    @GetMapping(value = "/roles")
    public ResponseEntity<?> getAllRoles() {
        try {
            return ResponseEntity.ok().body(roleService.getAllRoles());
        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error: "+e);
        }
    }
}
