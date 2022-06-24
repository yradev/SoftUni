package source.service;

import org.springframework.stereotype.Service;
import source.model.dto.EmployeeViewDTO;
import source.model.dto.UserLoginDTO;
import source.model.dto.UserRegisterDTO;

import java.util.List;

public interface UserService {
    boolean register(UserRegisterDTO userRegisterDTO);
    boolean login(UserLoginDTO userLoginDTO);
    void logout();
    List<EmployeeViewDTO> getEmployeeOrders();
}
