package com.likebookapp.service.IMPL;

import com.likebookapp.model.dto.PostAddDTO;
import com.likebookapp.model.dto.PostViewDTO;
import com.likebookapp.model.entity.Mood;
import com.likebookapp.model.entity.Post;
import com.likebookapp.model.entity.User;
import com.likebookapp.repository.MoodRepository;
import com.likebookapp.repository.PostRepository;
import com.likebookapp.repository.UserRepository;
import com.likebookapp.service.PostService;
import com.likebookapp.session.CurrentSession;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PostServiceIMPL implements PostService {
    private final PostRepository postRepository;
    private final UserRepository userRepository;
    private final ModelMapper modelMapper;
    private final CurrentSession currentSession;
    private final MoodRepository moodRepository;

    public PostServiceIMPL(PostRepository postRepository, UserRepository userRepository, ModelMapper modelMapper, CurrentSession currentSession, MoodRepository moodRepository) {
        this.postRepository = postRepository;
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
        this.currentSession = currentSession;
        this.moodRepository = moodRepository;
    }

    @Override
    public void addPost(PostAddDTO postAddDTO) {
        Post post = modelMapper.map(postAddDTO,Post.class);
        User user = userRepository.findUserByUsername(currentSession.getUsername());
        Mood mood = moodRepository.findMoodByName(postAddDTO.getMood());
        post.setCreator(user);
        post.setMood(mood);
        postRepository.saveAndFlush(post);
    }

    @Override
    public List<PostViewDTO> getPostsCurrentUser(String username) {

        return postRepository.findPostsByCreator_Username(username).stream()
                .map(post->modelMapper.map(post,PostViewDTO.class))
                .peek(post->{
                    if(post.getLikes()==null){
                        post.setNumberOfLikes(0);
                    }else{
                        post.setNumberOfLikes(post.getLikes().size());
                    }
                })
                .collect(Collectors.toList());
    }

    @Override
    public void removePost(long id) {
        Post post = postRepository.findPostById(id);
        postRepository.delete(post);
    }

    @Override
    public List<PostViewDTO> getOtherUsersPosts() {
        List<PostViewDTO> posts = postRepository.findAll().stream()
                .filter(post->!post.getCreator().getUsername().equals(currentSession.getUsername()))
                .map(post->modelMapper.map(post,PostViewDTO.class))
                .peek(post->{
                    if(post.getLikes()==null){
                        post.setNumberOfLikes(0);
                    }else{
                        post.setNumberOfLikes(post.getLikes().size());
                    }
                })
                .collect(Collectors.toList());

        return posts;
    }

    @Override
    public void addLike(long id) {
        Post post = postRepository.findPostById(id);
        User user = userRepository.findUserByUsername(currentSession.getUsername());
        post.getLikes().add(user);
        postRepository.saveAndFlush(post);
    }
}
