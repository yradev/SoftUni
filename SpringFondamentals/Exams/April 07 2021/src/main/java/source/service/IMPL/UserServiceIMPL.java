package source.service.IMPL;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import source.model.dto.EmployeeViewDTO;
import source.model.dto.UserLoginDTO;
import source.model.dto.UserRegisterDTO;
import source.model.entity.User;
import source.repository.UserRepository;
import source.service.UserService;
import source.session.CurrentSession;

import java.util.List;
import java.util.stream.Collectors;

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
    public boolean register(UserRegisterDTO userRegisterDTO) {
        if(userRepository.findUserByEmail(userRegisterDTO.getEmail()) != null ||
                userRepository.findUserByUsername(userRegisterDTO.getUsername())!=null ||
                !userRegisterDTO.getPassword().equals(userRegisterDTO.getConfirmPassword())){

            return false;
        }

        userRepository.save(modelMapper.map(userRegisterDTO, User.class));
        return true;
    }

    @Override
    public boolean login(UserLoginDTO userLoginDTO) {
        if(userRepository.findUserByUsernameAndPassword(userLoginDTO.getUsername(),userLoginDTO.getPassword()) == null){
            return false;
        }

        currentSession.login(modelMapper.map(userLoginDTO,User.class));
        return true;
    }

    @Override
    public void logout() {
        currentSession.logout();
    }

    @Override
    public List<EmployeeViewDTO> getEmployeeOrders() {

        return userRepository.findAll().stream()
                .map(a-> modelMapper.map(a,EmployeeViewDTO.class))
                .collect(Collectors.toList());
    }
}
