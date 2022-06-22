package source.service;

import source.model.dto.LoginDTO;
import source.model.dto.RegistrationDTO;

public interface UserService {
    boolean register(RegistrationDTO registrationDTO);
    boolean login(LoginDTO loginDTO);
}
