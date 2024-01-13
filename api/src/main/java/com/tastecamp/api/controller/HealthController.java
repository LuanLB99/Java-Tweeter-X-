package com.tastecamp.api.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;



@RestController
@RequestMapping
public class HealthController{
    
    @GetMapping
    public String helloSpring() {
    
        return "It's fine!!!";
    }
}



