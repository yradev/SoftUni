package softuni.exam.instagraphlite.service.impl;

import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import softuni.exam.instagraphlite.models.Picture.ImportDTO.PictureImportDTO;
import softuni.exam.instagraphlite.models.Picture.Picture;
import softuni.exam.instagraphlite.models.Post.ExportDTO.UserWithPostsDTO.UserWithPostsDTO;
import softuni.exam.instagraphlite.models.User.ImportDTO.UserImportDTO;
import softuni.exam.instagraphlite.models.User.User;
import softuni.exam.instagraphlite.repository.PictureRepository;
import softuni.exam.instagraphlite.repository.UserRepository;
import softuni.exam.instagraphlite.service.UserService;
import softuni.exam.instagraphlite.service.ValidatingService;

import java.io.IOException;
import java.nio.file.Files;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static softuni.exam.instagraphlite.util.Messages.INVALID_DATA_IMPORT;
import static softuni.exam.instagraphlite.util.Messages.SUCCESSFULLY_USER_IMPORT;
import static softuni.exam.instagraphlite.util.Paths.USERS_DATA;

@Service
public class UserServiceIMPL implements UserService {
    private final UserRepository userRepository;
    private final PictureRepository pictureRepository;
    private final ValidatingService validatingService;
    private final Gson gson;
    private final ModelMapper modelMapper;

    @Autowired
    public UserServiceIMPL(UserRepository userRepository, PictureRepository pictureRepository, ValidatingService validatingService, Gson gson, ModelMapper modelMapper) {
        this.userRepository = userRepository;
        this.pictureRepository = pictureRepository;
        this.validatingService = validatingService;
        this.gson = gson;
        this.modelMapper = modelMapper;
    }

    @Override
    public boolean areImported() {
        return userRepository.count()>0;
    }

    @Override
    public String readFromFileContent() throws IOException {
        return Files.readString(USERS_DATA);
    }

    @Override
    public String importUsers() throws IOException {
        return Arrays.stream(gson.fromJson(Files.readString(USERS_DATA), UserImportDTO[].class))
                .map(this::saveValidRecordToDataBase)
                .collect(Collectors.joining(System.lineSeparator()));
    }

    @Override
    public String exportUsersWithTheirPosts() {
        return userRepository.findUsersWithPosts().stream()
                .map(a->modelMapper.map(a, UserWithPostsDTO.class))
                .map(UserWithPostsDTO::toString)
                .collect(Collectors.joining());
    }

    private String saveValidRecordToDataBase(UserImportDTO userImportDTO){
        if(!validatingService.ValidateUser(userImportDTO)){
            return String.format(INVALID_DATA_IMPORT,"User");
        }

        Picture picture =  pictureRepository.findPictureByPath(userImportDTO.getProfilePicture());

        if(picture == null){
            return String.format(INVALID_DATA_IMPORT,"User");
        }

        User user = modelMapper.map(userImportDTO, User.class);
        user.setPicture(picture);

        userRepository.save(user);
        return String.format(SUCCESSFULLY_USER_IMPORT,userImportDTO.getUsername());
    }
}
