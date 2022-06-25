package com.example.spotifyplaylistapp.model.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class UserRegisterDTO {
    @Size(min = 3,max = 20,message = "Username length must be between 3 and 20 characters!")
    private String username;
    @NotEmpty(message = "Email cannot be empty!")
    @Email(message = "")
    private String email;
    @Size(min = 3,max = 20,message = "Password length must be between 3 and 20 characters!")
    private String password;
    @Size(min = 3,max = 20,message = "Password length must be between 3 and 20 characters!")
    private String confirmPassword;

    public UserRegisterDTO(){}

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }
}
