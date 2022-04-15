package game_store.Services.impl;

import game_store.Entities.Game;
import game_store.Entities.User;
import game_store.Services.ControlService;
import game_store.Services.GameService;
import game_store.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.Set;

import static game_store.Messages.CoreMessages.*;

@Service
public class ControlServiceIMPL implements ControlService {
    private User currentUser;
    private final UserService userService;
    private final GameService gameService;

    @Autowired
    public ControlServiceIMPL(UserService userService, GameService gameService) {
        this.userService = userService;
        this.gameService = gameService;
    }

    @Override
    public void executeCommand(String pick) {
        switch(pick.toLowerCase()){
            case "registeruser":
                if(!isLogged()) {
                    currentUser = userService.register();
                }else{
                    throw new IllegalArgumentException(LOGGED_ERROR);
                }
                break;
            case "loginuser":
                if(!isLogged()) {
                    currentUser = userService.login();
                }else{
                    throw new IllegalArgumentException(LOGGED_ERROR);
                }
                break;
            case "addgame":
                if(isCurrentUserAdmin()){
                    gameService.addGame();
                }else{
                    throw new IllegalArgumentException(NOT_ADMIN);
                }
                break;
            case"editgame":
                if(isCurrentUserAdmin()){
                    gameService.editGame();
                }else{
                    throw new IllegalArgumentException(NOT_ADMIN);
                }
                break;
            case "deletegame":
                if(isCurrentUserAdmin()){
                    gameService.deleteGame();
                }else{
                    throw new IllegalArgumentException(NOT_ADMIN);
                }
                break;
            case"allgames":
                gameService.printAllGames();
                break;
            case"detailsgame":
                gameService.printDetailGame();
                break;
            case"ownedgames":
               if(currentUser.getGames().isEmpty()){
                   throw new IllegalArgumentException(GAMELIST_EMPTY);
               }

               currentUser.getGames().forEach(a-> System.out.println(a.getTitle()));
            default: throw new IllegalArgumentException(INVALID_INPUT);
        }
    }

    @Override
    public boolean isLogged() {
        return currentUser != null;
    }

    @Override
    public boolean isCurrentUserAdmin() {
        return currentUser.isAdmin();
    }

    @Override
    public String getCurrentUserFullName() {
        return currentUser.getFullName();
    }

}
