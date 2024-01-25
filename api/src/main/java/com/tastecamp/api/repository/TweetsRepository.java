package com.tastecamp.api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import com.tastecamp.api.model.TweetModel;

public interface TweetsRepository extends JpaRepository <TweetModel, Long> {
    List<TweetModel> findAllByUserId(@Param("userId") Long userId);
}
