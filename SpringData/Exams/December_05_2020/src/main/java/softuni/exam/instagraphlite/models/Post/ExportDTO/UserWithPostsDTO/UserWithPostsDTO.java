package softuni.exam.instagraphlite.models.Post.ExportDTO.UserWithPostsDTO;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class UserWithPostsDTO {
    private String username;
    private int countPosts;

    private List<PostDetailsDTO> posts;

    public UserWithPostsDTO(){}

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public List<PostDetailsDTO> getPosts() {
        return posts;
    }

    public void setPosts(List<PostDetailsDTO> posts) {
        this.posts = posts;
        countPosts = posts.size();
    }

    @Override
    public String toString() {

        return String.format("""
                User: %s
                Post count: %s
                %s
                """,username,countPosts, posts.stream().sorted(Comparator.comparingDouble(PostDetailsDTO::getPictureSize)).map(PostDetailsDTO::toString).collect(Collectors.joining(System.lineSeparator())));
    }
}
