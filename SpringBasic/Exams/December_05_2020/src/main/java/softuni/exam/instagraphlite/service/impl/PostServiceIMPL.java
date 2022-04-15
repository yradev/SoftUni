package softuni.exam.instagraphlite.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import softuni.exam.instagraphlite.models.Picture.Picture;
import softuni.exam.instagraphlite.models.Post.ImportDTO.CollectionOfPosts;
import softuni.exam.instagraphlite.models.Post.ImportDTO.PostImportDTO;
import softuni.exam.instagraphlite.models.Post.Post;
import softuni.exam.instagraphlite.models.User.User;
import softuni.exam.instagraphlite.repository.PictureRepository;
import softuni.exam.instagraphlite.repository.PostRepository;
import softuni.exam.instagraphlite.repository.UserRepository;
import softuni.exam.instagraphlite.service.PostService;
import softuni.exam.instagraphlite.service.ValidatingService;
import softuni.exam.instagraphlite.util.XmlParser;

import javax.xml.bind.JAXB;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.IOException;
import java.nio.file.Files;
import java.util.stream.Collectors;

import static softuni.exam.instagraphlite.util.Messages.*;
import static softuni.exam.instagraphlite.util.Paths.POSTS_DATA;

@Service
public class PostServiceIMPL implements PostService {
    private final PostRepository postRepository;
    private final ValidatingService validatingService;
    private final ModelMapper modelMapper;
    private final UserRepository userRepository;
    private final PictureRepository pictureRepository;

    @Autowired
    public PostServiceIMPL(PostRepository postRepository, ValidatingService validatingService, ModelMapper modelMapper, UserRepository userRepository, PictureRepository pictureRepository) {
        this.postRepository = postRepository;
        this.validatingService = validatingService;
        this.modelMapper = modelMapper;
        this.userRepository = userRepository;
        this.pictureRepository = pictureRepository;
    }


    @Override
    public boolean areImported() {
        return postRepository.count()>0;
    }

    @Override
    public String readFromFileContent() throws IOException {
        return Files.readString(POSTS_DATA);
    }

    @Override
    public String importPosts() throws IOException, JAXBException {

        return XmlParser.getFromXml(CollectionOfPosts.class,POSTS_DATA.toFile()).getPosts().stream()
                .map(this::saveValidRecordToDataBase)
                .collect(Collectors.joining(System.lineSeparator()));
    }

    private String saveValidRecordToDataBase(PostImportDTO postImportDTO){
        if(!validatingService.ValidatePost(postImportDTO)){
            return String.format(INVALID_DATA_IMPORT,"Post");
        }

        User user = userRepository.findUserByUserName(postImportDTO.getUser().getUsername());
        Picture picture = pictureRepository.findPictureByPath(postImportDTO.getPicture().getPath());

        if(user==null || picture == null){
            return String.format(INVALID_DATA_IMPORT,"Post");
        }

        Post post = modelMapper.map(postImportDTO, Post.class);
        post.setUser(user);
        post.setPicture(picture);

        postRepository.save(post);
        return String.format(SUCCESSFULLY_POST_IMPORT,postImportDTO.getUser().getUsername());
    }
}
