package com.foody.controller;

import com.foody.service.StateImpl;
import com.foody.service.StateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StateController {
    @Autowired
    private StateImpl stateImpl;
}
