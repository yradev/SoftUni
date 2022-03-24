package game_store.Controllers;

import game_store.Services.ControlService;
import game_store.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;


import java.util.Scanner;

import static game_store.Messages.CoreMessages.*;

@Component
public class RunController implements CommandLineRunner {
    private Scanner scanner;

    private ControlService controlService;

    @Autowired
    public RunController(ControlService controlService,UserService userService) {
        this.controlService = controlService;
    }

    @Override
    public void run(String... args) throws Exception {
        scanner = new Scanner(System.in);

        while(true) {
            if(!controlService.isLogged()){
                executeNotLogged();
                continue;
            }

            System.out.printf(USER_LOGGED,controlService.getCurrentUserFullName());
            System.out.println();

            if(controlService.isCurrentUserAdmin()){
                System.out.println(ADMIN_CONDITIONS);
                System.out.println();
            }

            System.out.println(PUBLIC_USER_COMMANDS);

            String input = scanner.nextLine();
            try{
                    if(input.equalsIgnoreCase("Logout")) {
                        System.out.println(USER_LOGOUT);
                        break;
                    }
                    controlService.executeCommand(input);
            }
            catch (IllegalArgumentException e){
                System.out.println("ERROR: " + e.getMessage());
            }
        }
    }

    private void executeNotLogged() {
        try {
            System.out.println(NOT_LOGGED);
            String input = scanner.nextLine();
            controlService.executeCommand(input);
        }catch (IllegalArgumentException e){
            System.out.println("ERROR: "+ e.getMessage());
        }
    }
}
