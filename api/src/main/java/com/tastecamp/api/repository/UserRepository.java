package com.tastecamp.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tastecamp.api.model.User;
import java.util.List;


public interface UserRepository extends JpaRepository <User, Long> {
    public User findByUsername(String username);
}
