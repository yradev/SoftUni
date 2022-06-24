package source.model.dto;

import javax.validation.constraints.Size;

public class UserLoginDTO {
    @Size(min = 5,max = 20, message = "Username length must be between 5 and 20 characters.")
    private String username;
    @Size(min = 3, message = "Password length must be more than 3 characters long.")
    private String password;

    public UserLoginDTO (){}

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
