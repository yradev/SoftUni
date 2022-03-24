package game_store.Services;

import game_store.Entities.Game;

import java.util.Set;

public interface ControlService {

    void executeCommand(String pick);
    boolean isLogged();
    boolean isCurrentUserAdmin();
    String getCurrentUserFullName();
}
