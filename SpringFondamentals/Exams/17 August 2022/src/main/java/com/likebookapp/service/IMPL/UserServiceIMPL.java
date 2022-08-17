package com.likebookapp.service.IMPL;

import com.likebookapp.model.dto.UserLoginDTO;
import com.likebookapp.model.dto.UserRegisterDTO;
import com.likebookapp.model.entity.User;
import com.likebookapp.repository.UserRepository;
import com.likebookapp.service.UserService;
import com.likebookapp.session.CurrentSession;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Service
public class UserServiceIMPL implements UserService {
    private final UserRepository userRepository;
    private final ModelMapper modelMapper;
    private final CurrentSession currentSession;

    public UserServiceIMPL(UserRepository userRepository, ModelMapper modelMapper, CurrentSession currentSession) {
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
        this.currentSession = currentSession;
    }


    @Override
    public void registerUser(UserRegisterDTO userRegisterDTO) {
        if(userRegisterDTO.getPassword().equals(userRegisterDTO.getConfirmPassword())){
            userRepository.save(modelMapper.map(userRegisterDTO, User.class));
        }
    }

    @Override
    public void validateLogin(UserLoginDTO userLoginDTO, BindingResult bindingResult) {
        if(!userLoginDTO.getUsername().isEmpty()) {
            User user = userRepository.findUserByUsername(userLoginDTO.getUsername());
            if (user == null) {
                bindingResult.addError(new FieldError("userDoesntExistError", "username", "User doesnt exist!"));

            } else {
                if (!userLoginDTO.getPassword().equals(user.getPassword()) && !userLoginDTO.getPassword().isEmpty()) {
                    bindingResult.addError(new FieldError("userDoesntExistError", "password", "Password is not valid!"));
                }
            }
        }
    }

    @Override
    public void login(UserLoginDTO userLoginDTO) {
        currentSession.login(userRepository.findUserByUsername(userLoginDTO.getUsername()));
    }

    @Override
    public void logout() {
        currentSession.logout();
    }
}
