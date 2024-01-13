package com.tastecamp.api.controller;

import org.springframework.web.bind.annotation.RestController;

import com.tastecamp.api.dto.UserDTO;
import com.tastecamp.api.model.User;
import com.tastecamp.api.repository.UserRepository;

import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;




@RestController
@RequestMapping("/api/users")
public class UsersController {
    
    @Autowired
    private UserRepository repository;
    
    @GetMapping
    public List<User> getUsers() {
        return repository.findAll();
    }

    @PostMapping("sign-up")
    public String createUser(@RequestBody UserDTO user) {
        repository.save(new User(user));
        return "OK";
        
    }
    
    

}
