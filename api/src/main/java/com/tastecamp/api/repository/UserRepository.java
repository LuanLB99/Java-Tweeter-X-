package com.tastecamp.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tastecamp.api.model.User;

public interface UserRepository extends JpaRepository <User, Long> {
    
}
