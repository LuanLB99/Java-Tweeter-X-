package com.tastecamp.api.controller;

import org.springframework.web.bind.annotation.RestController;

import com.tastecamp.api.dto.TweetsDTO;
import com.tastecamp.api.model.Tweet;
import com.tastecamp.api.service.TweetsService;

import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;




@RestController
@RequestMapping("/tweets")
public class TweetsController {

    @Autowired
    private TweetsService tweetsService;
    
    @GetMapping
    public List<Tweet> listTweets() {
        return tweetsService.listTweets();
    }

    @PostMapping
    public String postMethodName(@RequestBody TweetsDTO tweet) {
        tweetsService.createTWeet(tweet);
        
        return "OK";
    }
    
}
