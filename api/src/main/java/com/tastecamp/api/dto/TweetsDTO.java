package com.tastecamp.api.dto;


import com.tastecamp.api.model.TweetModel;
import com.tastecamp.api.model.UserModel;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class TweetsDTO{
    
    @NotNull(message = "O ID precisa ser um número")
    private Long userId;

    @NotBlank(message = "O texto de tweet não pode estar vazio.")
    @Size(max = 280, message = "O máximo de caractéres é 280!")
    private String text;

    public TweetModel convertToTweetModel(UserModel user){
        TweetModel tweet = new TweetModel();
        tweet.setText(text);
        tweet.setUser(user);

        return tweet;
    }
    
}
