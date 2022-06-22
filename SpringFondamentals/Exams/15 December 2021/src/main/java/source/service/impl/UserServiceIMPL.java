package source.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import source.model.dto.LoginDTO;
import source.model.dto.RegistrationDTO;
import source.model.entity.User;
import source.repository.UserRepository;
import source.service.UserService;
import source.session.CurrentSession;

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
    public boolean register(RegistrationDTO registrationDTO) {
        if(!registrationDTO.getPassword().equals(registrationDTO.getConfirmPassword()) ||
           userRepository.findUserByUsername(registrationDTO.getUsername()) != null ||
           userRepository.findUserByEmail(registrationDTO.getEmail()) != null){
            return false;
        }

        userRepository.save(modelMapper.map(registrationDTO, User.class));
        return true;
    }

    @Override
    public boolean login(LoginDTO loginDTO) {
        User user = userRepository.findUserByUsernameAndPassword(loginDTO.getUsername(),loginDTO.getPassword());
        if(user==null){
            return false;
        }

        currentSession.login(user);
        return true;
    }

}
