package game_store.Entities.DTO;

import org.springframework.validation.annotation.Validated;

@Validated
public class RegisterDTO {
    private final String email;
    private final String password;
    private final String confirmPassword;
    private final String fullName;

    public RegisterDTO(String email, String password, String confirmPassword, String fullName) {
        this.email = email;
        this.password = password;
        this.confirmPassword = confirmPassword;
        this.fullName = fullName;
    }

    public String getPassword() {
        return password;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public String getFullName() {
        return fullName;
    }

    public String getEmail() {
        return email;
    }
}
