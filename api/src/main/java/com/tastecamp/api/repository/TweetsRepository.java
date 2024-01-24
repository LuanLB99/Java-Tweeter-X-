package com.tastecamp.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tastecamp.api.model.TweetModel;

public interface TweetsRepository extends JpaRepository <TweetModel, Long> {
    
}
