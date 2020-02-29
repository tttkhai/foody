package com.foody.controller;

import com.foody.service.RoleImpl;
import com.foody.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class RoleController {
    @Autowired
    private RoleImpl roleImpl;
}
