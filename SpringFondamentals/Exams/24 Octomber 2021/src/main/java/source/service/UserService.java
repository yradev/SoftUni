package source.service;

import source.model.dto.UserLoginDTO;
import source.model.dto.UserRegisterDTO;

public interface UserService {
    boolean register(UserRegisterDTO userRegisterDTO);
    boolean login(UserLoginDTO userLoginDTO);
    void logout();
}
