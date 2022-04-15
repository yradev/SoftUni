package game_store.Services.validators;

public interface UserValidatorService {
    void validateRegisterEmail(String email);
    void validatePassword(String password);
    void validateConfirmPassword(String password,String confirmPassword);
    void validateLoginEmail(String email);
    void validateLogin(String email,String password);
}
