package source.model.dto;

import org.springframework.lang.NonNull;

import javax.validation.constraints.*;

public class UserRegisterDTO {
    @Size(min = 5,max = 20, message = "Username length must be between 5 and 20 characters.")
    private String username;
    private String firstName;
    @Size(min = 5, max = 20, message = "Last name length must be between 5 and 20 characters.")
    private String lastName;
    @NotBlank(message = "Enter valid email address.")
    @Email(message = "Enter valid email address.")
    private String email;
    @Size(min = 3, message = "Password length must be more than 3 characters long.")
    private String password;
    @Size(min = 3, message = "Password length must be more than 3 characters long.")
    private String confirmPassword;

    public UserRegisterDTO(){}

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }
}
