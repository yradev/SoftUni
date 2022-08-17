package com.likebookapp.service;

import com.likebookapp.model.dto.*;
import org.springframework.validation.BindingResult;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


public interface UserService {
    void registerUser(UserRegisterDTO userRegisterDTO);
    void validateLogin(UserLoginDTO userLoginDTO, BindingResult bindingResult);

    void login(UserLoginDTO userLoginDTO);

    void logout();
}
