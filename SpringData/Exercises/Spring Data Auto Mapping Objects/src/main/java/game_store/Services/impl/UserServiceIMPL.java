package game_store.Services.impl;

import game_store.Entities.DTO.RegisterDTO;
import game_store.Entities.User;
import game_store.Repositories.UserRepository;
import game_store.Services.ControlService;
import game_store.Services.UserService;
import game_store.Services.validators.UserValidatorService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Scanner;

import static game_store.Messages.CoreMessages.*;

@Service
public class UserServiceIMPL implements UserService {
    private Scanner scanner;
    private UserRepository userRepository;
    private UserValidatorService validatingService;

    @Autowired
    public UserServiceIMPL(UserRepository userRepository, UserValidatorService validatingService) {
        this.userRepository = userRepository;
        this.validatingService = validatingService;
        scanner = new Scanner(System.in);
    }

    @Override
    public User register() {
        System.out.println(ENTER_EMAIL);
        String email = scanner.nextLine();

        validatingService.validateRegisterEmail(email);


        System.out.println(PASSWORD_REQUIREMENTS);
        System.out.println(ENTER_PASSWORD);
        String password = scanner.nextLine();

        validatingService.validatePassword(password);

        System.out.println(ENTER_CONFIRM_PASSWORD);
        String confirmPassword = scanner.nextLine();

        validatingService.validateConfirmPassword(password,confirmPassword);
        System.out.println(ENTER_FULL_NAME);
        String fullName = scanner.nextLine();

        RegisterDTO regUser = new RegisterDTO(email,password,confirmPassword,fullName);

        ModelMapper modelMapper = new ModelMapper();
        User newUser = modelMapper.map(regUser, User.class);
        System.out.printf(USER_REGISTERED,fullName);
        if(userRepository.count()==0){
            newUser.setAdmin(true);
            System.out.printf(USER_ADMIN,email);
        }
        userRepository.save(newUser);
        return newUser;
    }

    @Override
    public User login() {
        System.out.println(ENTER_EMAIL);
        String email = scanner.nextLine();

        validatingService.validateLoginEmail(email);
        System.out.println(ENTER_PASSWORD);

        String password = scanner.nextLine();
        validatingService.validateLogin(email,password);

        return userRepository.findUsersByEmailAndPassword(email,password).get(0);
    }
}
