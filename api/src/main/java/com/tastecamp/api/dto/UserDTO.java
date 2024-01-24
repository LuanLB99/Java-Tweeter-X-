package com.tastecamp.api.dto;


import com.tastecamp.api.model.UserModel;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class UserDTO{

    @NotBlank
    @Size(max = 100, message = "O Máximo de caracteres é 100!")
    private String username;

    @NotBlank
    private String avatar;

    public UserModel convert(){
        UserModel user = new UserModel();
        user.setUsername(username);
        user.setAvatar(avatar);

        return user;
    }

}
