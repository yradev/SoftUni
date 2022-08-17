package com.likebookapp.service;

import com.likebookapp.model.dto.PostAddDTO;
import com.likebookapp.model.dto.PostViewDTO;

import java.util.List;

public interface PostService {
    void addPost(PostAddDTO postAddDTO);

    List<PostViewDTO> getPostsCurrentUser(String username);

    void removePost(long id);

    List<PostViewDTO> getOtherUsersPosts();

    void addLike(long id);
}
