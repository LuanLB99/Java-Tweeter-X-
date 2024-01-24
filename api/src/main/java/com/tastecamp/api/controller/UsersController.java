package com.tastecamp.api.controller;

import org.springframework.web.bind.annotation.RestController;

import com.tastecamp.api.dto.UserDTO;
import com.tastecamp.api.exception.ConflictUserException;
import com.tastecamp.api.model.UserModel;
import com.tastecamp.api.service.UserService;

import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;




@RestController
@RequestMapping("users")
public class UsersController {
    
    @Autowired
    private UserService UserService;
    
    @GetMapping
    public ResponseEntity<Object> getUsers() {
        List<UserModel> users = UserService.listUsers();
        return ResponseEntity.status(HttpStatus.OK).body(users);
    }

    @PostMapping
    public ResponseEntity<Object> createUser(@RequestBody @Valid UserDTO form, BindingResult bindingResult) {
        if(bindingResult.hasErrors()){
            String errorMessage = "Erro de validação: " + bindingResult.getFieldError().getDefaultMessage();
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorMessage);
        }


        try {
            UserModel user = UserService.createUser(form);
            return ResponseEntity.status(HttpStatus.CREATED).body(user);
        } catch (ConflictUserException e) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Erro de conflito: " + e.getMessage());
        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
        
    }
    
    

}
