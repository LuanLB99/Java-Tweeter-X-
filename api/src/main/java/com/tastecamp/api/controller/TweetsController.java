package com.tastecamp.api.controller;

import org.springframework.web.bind.annotation.RestController;

import com.tastecamp.api.dto.TweetsDTO;
import com.tastecamp.api.exception.NotFoundException;
import com.tastecamp.api.model.TweetModel;
import com.tastecamp.api.service.TweetsService;

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
@RequestMapping("/tweets")
public class TweetsController {

    @Autowired
    private TweetsService tweetsService;
    
    @GetMapping
    public ResponseEntity<Object> listTweets() {
        try {
            List<TweetModel> tweets = tweetsService.listTweets();
            return ResponseEntity.status(HttpStatus.OK).body(tweets);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
       
    }

    @PostMapping
    public ResponseEntity<Object> postMethodName(@RequestBody @Valid TweetsDTO formTweet, BindingResult bindingResult) {
        if(bindingResult.hasErrors()){
            String errorMessage = "Erro de validação: " + bindingResult.getFieldError().getDefaultMessage();
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorMessage);
        }

        try {
          TweetModel tweet =  tweetsService.createTWeet(formTweet);
          return ResponseEntity.status(HttpStatus.CREATED).body(tweet);

        } catch (NotFoundException e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        } 
            
    }
    
}
