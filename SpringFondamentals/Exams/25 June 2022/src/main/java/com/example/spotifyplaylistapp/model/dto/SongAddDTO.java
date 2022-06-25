package com.example.spotifyplaylistapp.model.dto;

import com.example.spotifyplaylistapp.model.entity.Style;
import com.example.spotifyplaylistapp.model.entity.Styles;
import com.example.spotifyplaylistapp.model.entity.User;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.*;
import java.time.LocalDate;
import java.util.Set;

public class SongAddDTO {
    @Size(min = 3,max = 20, message = "Performer name must be between 3 and 20 characters (inclusive 3 and 20).")
    private String performer;
    @Size(min = 2, max = 20, message = "Title length must be between 2 and 20 characters (inclusive 2 and 20).")
    private String title;
    @NotNull(message = "")
    @PastOrPresent(message = "The date cannot be in future")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate releaseDate;

    @Positive(message = "duration must be positive")
    private int duration;

    @NotNull(message = "You must select a style")
    private Styles styleName;

    private Style style;

    private Set<User> users;

    public SongAddDTO(){}

    public String getPerformer() {
        return performer;
    }

    public void setPerformer(String performer) {
        this.performer = performer;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public LocalDate getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(LocalDate releaseDate) {
        this.releaseDate = releaseDate;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public Style getStyle() {
        return style;
    }

    public void setStyle(Style style) {
        this.style = style;
    }

    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }

    public Styles getStyleName() {
        return styleName;
    }

    public void setStyleName(Styles styleName) {
        this.styleName = styleName;
    }
}
