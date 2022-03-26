package products_shop.Services.IMPL;

import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import products_shop.Entities.Users.User;
import products_shop.Entities.Users.UserWithSoldItemsDTO;
import products_shop.Entities.Users.UsersThatHaveSoldAtLeastOneItemDTO;
import products_shop.Repositories.UserRepository;
import products_shop.Services.UserService;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class UserServiceIMPL implements UserService {
    private UserRepository userRepository;
    private Gson gson;
    private ModelMapper modelMapper;

    @Autowired
    public UserServiceIMPL(UserRepository userRepository, Gson gson, ModelMapper modelMapper) {
        this.userRepository = userRepository;
        this.gson = gson;
        this.modelMapper = modelMapper;
    }

    @Override
    public String getUserBySoldProjects() {
        List<User>users = userRepository.findUsersBySoldProjects();
        List<UserWithSoldItemsDTO> userList = users.stream()
                .map(a->modelMapper.map(a,UserWithSoldItemsDTO.class))
                .filter(a->!a.getBoughtItems().isEmpty())
                .collect(Collectors.toList());
        return gson.toJson(userList);
    }

    @Override
    public String getUsersByCountSoldProjects() {

    List<User>users = userRepository.findAllWithSoldProductsOrderByCount();

        UsersThatHaveSoldAtLeastOneItemDTO userDTO = new UsersThatHaveSoldAtLeastOneItemDTO(users.size());
        List<UserWithSoldItemsDTO> userList = users.stream()
                .map(a->modelMapper.map(a,UserWithSoldItemsDTO.class))
                .filter(a->!a.getBoughtItems().isEmpty())
                .collect(Collectors.toList());
        userDTO.setUsers(userList);

        return gson.toJson(userDTO);
    }
}
