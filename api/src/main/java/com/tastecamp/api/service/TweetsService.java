package com.tastecamp.api.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tastecamp.api.dto.TweetsDTO;
import com.tastecamp.api.exception.NotFoundException;
import com.tastecamp.api.model.TweetModel;
import com.tastecamp.api.model.UserModel;
import com.tastecamp.api.repository.TweetsRepository;
import com.tastecamp.api.repository.UserRepository;


@Service
public class TweetsService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private TweetsRepository tweetsRepository;

    public List<TweetModel> listTweets(){
        return tweetsRepository.findAll();
    }

    public List<TweetModel> listTweetUserById(Long userId){
        return tweetsRepository.findAllByUserId(userId);
    }

    public TweetModel createTWeet(TweetsDTO tweet) throws NotFoundException{
        UserModel user = userRepository.findById(tweet.getUserId())
        .orElseThrow(() -> new NotFoundException("Usuário não encontrado!"));

        TweetModel newTweet = tweet.convertToTweetModel(user);
        tweetsRepository.save(newTweet);
        return newTweet;
    }
}
