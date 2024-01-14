package com.tastecamp.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tastecamp.api.dto.TweetsDTO;
import com.tastecamp.api.model.Tweet;
import com.tastecamp.api.model.User;
import com.tastecamp.api.repository.TweetsRepository;
import com.tastecamp.api.repository.UserRepository;


@Service
public class TweetsService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private TweetsRepository tweetsRepository;

    public List<Tweet> listTweets(){
        return tweetsRepository.findAll();
    }

    public void createTWeet(TweetsDTO tweet){
        String userTweet = tweet.username();
       User user = userRepository.findByUsername(userTweet);
       Tweet newTweet = tweetsRepository.save(new Tweet(user.getUsername(), user.getAvatar(), tweet.tweet()));
    }
}
