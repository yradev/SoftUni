package softuni.exam.instagraphlite.models.Picture;

import softuni.exam.instagraphlite.models.Post.Post;
import softuni.exam.instagraphlite.models.User.User;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "pictures")
public class Picture {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(unique = true)
    private String path;

    private double size;

    @OneToMany(targetEntity = User.class,mappedBy = "picture")
    private Set<User>users;

    @OneToMany(targetEntity = Post.class,mappedBy = "picture")
    private Set<Post> posts;

    public Picture(){}

    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }

    public Set<Post> getPosts() {
        return posts;
    }

    public void setPosts(Set<Post> posts) {
        this.posts = posts;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public double getSize() {
        return size;
    }

    public void setSize(double size) {
        this.size = size;
    }
}
