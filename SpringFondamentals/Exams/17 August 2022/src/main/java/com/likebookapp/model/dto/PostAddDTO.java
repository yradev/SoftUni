package com.likebookapp.model.dto;

import com.likebookapp.model.entity.Mood;
import com.likebookapp.model.entity.enums.MoodName;

import javax.validation.constraints.Size;

public class PostAddDTO {
    @Size(min = 2,max = 150,message = "Content length must be between 2 and 150 characters!")
    private String content;

    private MoodName mood;

    public PostAddDTO(){}

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public MoodName getMood() {
        return mood;
    }

    public void setMood(MoodName mood) {
        this.mood = mood;
    }
}
