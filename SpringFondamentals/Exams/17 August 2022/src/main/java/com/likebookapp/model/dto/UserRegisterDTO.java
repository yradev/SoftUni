package com.likebookapp.model.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

public class UserRegisterDTO {
    @Size(min=3, max= 20,message = "Username length must be between 3 and 20 characters!")
    private String username;
    @Size(min = 3,max = 20,message = "Password length must be between 3 and 20 characters!")
    private String password;
    @Size(min = 3,max = 20,message = "Password length must be between 3 and 20 characters!")
    private String confirmPassword;
    @Email(message = "Email is invalid!")
    @NotEmpty(message = "Email cannot be empty!")
    private String email;

    public UserRegisterDTO(){}

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
