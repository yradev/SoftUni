package com.likebookapp.model.entity;

import com.likebookapp.model.entity.enums.MoodName;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "moods")
public class Mood extends BaseEntity{
    @Column(nullable = false)
    private MoodName name;
    @Column(columnDefinition = "text")
    private String description;

    @OneToMany(mappedBy = "mood",targetEntity = Post.class)
    private List<Post> posts;

    public Mood (){}

    public MoodName getName() {
        return name;
    }

    public void setName(MoodName name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Post> getPosts() {
        return posts;
    }

    public void setPosts(List<Post> posts) {
        this.posts = posts;
    }
}
