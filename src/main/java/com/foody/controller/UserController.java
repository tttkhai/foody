package com.foody.controller;

import com.foody.service.UserImpl;
import com.foody.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class UserController {

    @Autowired
    private UserImpl userImpl;
}
