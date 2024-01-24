package com.tastecamp.api.model;

import java.net.URL;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "tweets")
@NoArgsConstructor
public class TweetModel {
    
    public TweetModel(String username, URL avatar, String tweet){
        this.text = tweet;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(length = 300, nullable = false)
    private String text;

    @Column(nullable = false)
    private UserModel user;



}
