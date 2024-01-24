package com.tastecamp.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tastecamp.api.model.UserModel;


public interface UserRepository extends JpaRepository <UserModel, Long> {
    public UserModel findByUsername(String username);
}
