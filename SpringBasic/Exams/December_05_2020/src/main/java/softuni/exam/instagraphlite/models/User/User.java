package softuni.exam.instagraphlite.models.User;

import softuni.exam.instagraphlite.models.Picture.Picture;
import softuni.exam.instagraphlite.models.Post.Post;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "username",unique = true)
    private String userName;

    private String password;

    @ManyToOne(optional = false)
    @JoinColumn(name = "profile_picture_id",referencedColumnName = "id")
    private Picture picture;

    @OneToMany(targetEntity = Post.class,mappedBy = "user")
    private Set<Post> posts;

    public User(){}

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

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Picture getPicture() {
        return picture;
    }

    public void setPicture(Picture picture) {
        this.picture = picture;
    }
}
