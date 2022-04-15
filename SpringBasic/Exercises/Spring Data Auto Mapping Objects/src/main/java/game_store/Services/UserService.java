package game_store.Services;

import game_store.Entities.User;

public interface UserService {
    User register();
    User login();
}
