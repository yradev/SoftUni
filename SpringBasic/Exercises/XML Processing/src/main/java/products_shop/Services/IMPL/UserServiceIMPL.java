package products_shop.Services.IMPL;


import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import products_shop.Entities.Users.CollectionsDTO.CollectionUsersWithSoldItemsDTO;
import products_shop.Entities.Users.User;
import products_shop.Entities.Users.UserWithSoldItemsDTO;
import products_shop.Entities.Users.CollectionsDTO.CollectionUsersThatHaveSoldAtLeastOneIteMDTO;
import products_shop.Repositories.UserRepository;
import products_shop.Services.UserService;

import javax.transaction.Transactional;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class UserServiceIMPL implements UserService {
    private UserRepository userRepository;
    private ModelMapper modelMapper;

    @Autowired
    public UserServiceIMPL(UserRepository userRepository, ModelMapper modelMapper) {
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public void getUserBySoldProjects() throws JAXBException {

        Marshaller marshaller = JAXBContext.newInstance(CollectionUsersWithSoldItemsDTO.class).createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT,true);

        List<User>users = userRepository.findUsersBySoldProjects();
        List<UserWithSoldItemsDTO> userList = users.stream()
                .map(a->modelMapper.map(a,UserWithSoldItemsDTO.class))
                .filter(a->!a.getBoughtItems().isEmpty())
                .collect(Collectors.toList());

        CollectionUsersWithSoldItemsDTO us = new CollectionUsersWithSoldItemsDTO(userList);
        marshaller.marshal(us,System.out);
    }

    @Override
    public void getUsersByCountSoldProjects() throws JAXBException {

    List<User>users = userRepository.findAllWithSoldProductsOrderByCount();

        CollectionUsersThatHaveSoldAtLeastOneIteMDTO userDTO = new CollectionUsersThatHaveSoldAtLeastOneIteMDTO();
        List<UserWithSoldItemsDTO> userList = users.stream()
                .map(a->modelMapper.map(a,UserWithSoldItemsDTO.class))
                .filter(a->!a.getBoughtItems().isEmpty())
                .collect(Collectors.toList());
        userDTO.setUsers(userList);

        Marshaller marshaller = JAXBContext.newInstance(CollectionUsersThatHaveSoldAtLeastOneIteMDTO.class).createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT,true);
        marshaller.marshal(userDTO,System.out);
    }
}
