package com.tastecamp.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tastecamp.api.dto.UserDTO;
import com.tastecamp.api.model.User;
import com.tastecamp.api.repository.UserRepository;

@Service
public class UserService {
    
    @Autowired
    private UserRepository userRepository;
    

    public List<User> listUsers() {
        return userRepository.findAll();
    }

    public void createUser(UserDTO user){
        userRepository.save(new User(user));
    }
}
