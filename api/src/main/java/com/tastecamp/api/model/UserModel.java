package com.tastecamp.api.model;

import java.net.URL;

import com.tastecamp.api.dto.UserDTO;

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
@Table(name = "Users")
@NoArgsConstructor

public class UserModel {

    public UserModel(UserDTO data){
        this.username = data.getUsername();
        this.avatar = data.getAvatar();
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(length = 20, nullable = false)
    private String username;

    @Column(length = 100, nullable = false)
    private String avatar;

}
