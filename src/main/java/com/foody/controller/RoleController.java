package com.foody.controller;

import com.foody.service.RoleImpl;
import com.foody.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RoleController {
    @Autowired
    private RoleImpl roleImpl;
}
