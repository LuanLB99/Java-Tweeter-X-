package com.tastecamp.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tastecamp.api.model.Tweet;

public interface TweetsRepository extends JpaRepository <Tweet, Long> {
    
}
