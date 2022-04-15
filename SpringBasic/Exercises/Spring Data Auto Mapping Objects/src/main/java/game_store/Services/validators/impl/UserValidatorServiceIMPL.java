package game_store.Services.validators.impl;

import game_store.Repositories.UserRepository;
import game_store.Services.validators.UserValidatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static game_store.Messages.CoreMessages.*;

@Service
public class UserValidatorServiceIMPL implements UserValidatorService {

    private UserRepository userRepository;

    @Autowired
    public UserValidatorServiceIMPL(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void validateRegisterEmail(String email) {
        if(userRepository.findUsersByEmail(email).size()==1){
            throw new IllegalArgumentException(String.format(USER_EXIST,email));
        }

        if(!email.matches("^[A-z\\d_]+@[A-z]+\\.[A-z]+")){
            throw new IllegalArgumentException(INVALID_INPUT_EMAIL);
        }
    }

    @Override
    public void validatePassword(String password) {

        boolean isUper = false;
        boolean isLower = false;
        boolean isDigit = false;

        char[] chars = password.toCharArray();

        if(chars.length<6){
            throw new IllegalArgumentException(INVALID_PASSWORD_LENGTH);
        }

        for (char c : chars) {
            if(Character.isDigit(c)){
                isDigit=true;
            }

            if(Character.isLowerCase(c)){
                isLower=true;
            }

            if(Character.isUpperCase(c)){
                isUper=true;
            }
        }

        boolean passwordCheck = isDigit && isLower && isUper;

        if(!passwordCheck){
            throw new IllegalArgumentException(INVALID_INPUT_PASSWORD);
        }
    }

    @Override
    public void validateConfirmPassword(String password, String confirmPassword) {
        if(!password.equals(confirmPassword)){
            throw new IllegalArgumentException(INVALID_INPUT_CONFIRM_PASSWORD);
        }
    }

    @Override
    public void validateLoginEmail(String email) {
        if(userRepository.findUsersByEmail(email).size()==0){
            throw new IllegalArgumentException(String.format(USER_DIDNT_EXIST,email));
        }
    }

    @Override
    public void validateLogin(String email, String password) {

        if(userRepository.findUsersByEmailAndPassword(email,password).size()==0){
            throw new IllegalArgumentException(PASSWORD_INCORRECT);
        }
    }
}
