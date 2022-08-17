package com.likebookapp.session;

import com.likebookapp.model.entity.User;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

@Component
@SessionScope
public class CurrentSession {
    private long id;
    private String username;
    private User user;

    public void login(User user) {
        this.id = user.getId();
        this.username = user.getUsername();
        this.user = user;
    }

    public void logout() {
        id = 0;
        username = null;
    }

    public boolean isLogged(){
        return username != null;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
