package com.tastecamp.api.model;

import java.net.URL;

import com.tastecamp.api.dto.TweetsDTO;

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
public class Tweet {
    
    public Tweet(String username, URL avatar, String tweet){
        this.username = username;
        this.avatar = avatar;
        this.text = tweet;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(length = 20, nullable = false)
    private String username;

    @Column(length = 100, nullable = false)
    private URL avatar;

    @Column(length = 300, nullable = false)
    private String text;

}
