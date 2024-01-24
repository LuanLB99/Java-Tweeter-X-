package com.tastecamp.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tastecamp.api.dto.UserDTO;
import com.tastecamp.api.exception.ConflictUserException;
import com.tastecamp.api.model.UserModel;
import com.tastecamp.api.repository.UserRepository;

@Service
public class UserService {
    
    @Autowired
    private UserRepository userRepository;
    

    public List<UserModel> listUsers() {
        return userRepository.findAll();
    }

    public UserModel createUser(UserDTO form) throws ConflictUserException{
        UserModel user = form.convert();

        UserModel haveUser = userRepository.findByUsername(user.getUsername());
        if(haveUser == null){
            userRepository.save(user);

        } else if (haveUser.getUsername().equals(user.getUsername())){
            throw new ConflictUserException();
        }
        return user;
    }
}
