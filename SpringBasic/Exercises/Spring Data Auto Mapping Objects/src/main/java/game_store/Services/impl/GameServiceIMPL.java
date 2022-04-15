package game_store.Services.impl;

import game_store.Entities.Game;
import game_store.Repositories.GameRepository;
import game_store.Services.GameService;
import game_store.Services.validators.GameValidatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;

import static game_store.Messages.CoreMessages.*;

@Service
public class GameServiceIMPL implements GameService {
    private GameRepository gameRepository;
    private GameValidatorService gameValidatorService;

    private Scanner scanner;

    @Autowired
    public GameServiceIMPL(GameRepository gameRepository, GameValidatorService gameValidatorService) {
        this.gameValidatorService = gameValidatorService;
        this.gameRepository = gameRepository;
        scanner = new Scanner(System.in);
    }


    @Override
    public void addGame() {
        System.out.println(ENTER_TITLE);
        String title = scanner.nextLine();
        gameValidatorService.validateTitle(title);

        System.out.println(ENTER_PRICE);
        BigDecimal price = BigDecimal.valueOf(Integer.parseInt(scanner.nextLine()));
        gameValidatorService.validatePrice(price);

        System.out.println(ENTER_SIZE);
        BigDecimal size = BigDecimal.valueOf(Integer.parseInt(scanner.nextLine()));
        gameValidatorService.validateSize(size);

        System.out.println(ENTER_TRAILER);
        String trialer = scanner.nextLine();
        gameValidatorService.validateTrailer(trialer);

        System.out.println(ENTER_THUBNAIL_URL);
        String thubnailURL = scanner.nextLine();
        gameValidatorService.validateThumbnailURL(thubnailURL);

        System.out.println(ENTER_DESCRIPTION);
        String description = scanner.nextLine();
        gameValidatorService.validateDescription(description);

        System.out.println(ENTER_RELEASE_DATE);
        String release_date_input = scanner.nextLine();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        LocalDate release_date;
        try {
            release_date = LocalDate.parse(release_date_input, formatter);
        }catch (DateTimeException e){
            throw new IllegalArgumentException(e.getMessage());
        }

        Game game = new Game(title,trialer,thubnailURL,size,price,description,release_date);
        gameRepository.save(game);
        System.out.println(GAME_ADDED);

    }

    @Override
    public void editGame() {
        System.out.println(ENTER_ID);
        int id = Integer.parseInt(scanner.nextLine());
        gameValidatorService.validateGameById(id);
        Game selectedGame = gameRepository.findGameById(id).get(0);

        while(true) {
            System.out.printf(SELECTED_GAME, selectedGame.getTitle());
            String pick = scanner.nextLine();

            if(pick.equalsIgnoreCase("save")){
                System.out.printf(GAME_EDITED,selectedGame.getTitle());
                break;
            }

            String [] split = pick.split(" ");

            String result;
            try {
                switch (split[0].toLowerCase()) {
                    case "title":
                        gameValidatorService.validateTitle(split[1]);
                        result = String.format(TITLE_EDITED,selectedGame.getTitle(),split[1]);
                        selectedGame.setTitle(split[1]);
                        System.out.println(result);
                        break;
                    case "price":
                        gameValidatorService.validatePrice(BigDecimal.valueOf(Integer.parseInt(split[1])));
                        result = String.format(PRICE_EDITED,selectedGame.getPrice(),Integer.parseInt(split[1]));
                        selectedGame.setPrice(BigDecimal.valueOf(Double.parseDouble(split[1])));
                        System.out.println(result);
                        break;
                    case "size":
                        gameValidatorService.validatePrice(BigDecimal.valueOf(Double.parseDouble(split[1])));
                        result = String.format(SIZE_EDITED,selectedGame.getSize(),Integer.parseInt(split[1]));
                        selectedGame.setSize(BigDecimal.valueOf(Integer.parseInt(split[1])));
                        System.out.println(result);
                        break;
                    case "trailer":
                        gameValidatorService.validateTrailer(split[1]);
                        result = String.format(TRAILER_EDITED,selectedGame.getTrailer(),split[1]);
                        selectedGame.setTrailer(split[1]);
                        System.out.println(result);
                        break;
                    case "thumbnail_url":
                        gameValidatorService.validateThumbnailURL(split[1]);
                        result = String.format(THUMBNAIL_URL_EDITED,selectedGame.getThumbnail(),split[1]);
                        selectedGame.setThumbnail(split[1]);
                        System.out.println(result);
                        break;
                    case "description":
                        gameValidatorService.validateDescription(split[1]);
                        result = String.format(DESCRIPTION_EDITED,selectedGame.getDescription(),split[1]);
                        selectedGame.setDescription(split[1]);
                        System.out.println(result);
                        break;
                    case "release_date":
                        try {
                            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
                            result = String.format(RELEASE_DATE_EDITED,selectedGame.getReleaseDate().toString(),LocalDate.parse(split[1],formatter));
                            selectedGame.setReleaseDate(LocalDate.parse(split[1],formatter));
                            System.out.println(result);
                        } catch (DateTimeException e) {
                            throw new IllegalArgumentException(e.getMessage());
                        }
                        break;
                }
            }catch (IllegalArgumentException e){
                System.out.println("ERROR: " + e.getMessage());
            }
        }
        gameRepository.save(selectedGame);
    }

    @Override
    public void deleteGame() {
        System.out.println(ENTER_ID);
        int id = Integer.parseInt(scanner.nextLine());
        gameValidatorService.validateGameById(id);

        String gameTitle = gameRepository.findGameById(id).get(0).getTitle();
        gameRepository.delete(gameRepository.findGameById(id).get(0));
        System.out.printf(GAME_DELETED,gameTitle);
    }

    @Override
    public void printAllGames() {
        List<Game> games = gameRepository.findAll();
        if(games.size() == 0){
            System.out.println(GAMELIST_EMPTY);
        }else {
            games.forEach(a -> System.out.printf("%s %s\n", a.getTitle(), a.getPrice()));
        }
    }

    @Override
    public void printDetailGame() {
        System.out.println(ENTER_TITLE);
        String title = scanner.nextLine();
        gameValidatorService.validateGameByTitle(title);

        Game currGame = gameRepository.findGamesByTitle(title).get(0);

        System.out.printf(GAME_DETAILS,currGame.getTitle(),currGame.getPrice(),currGame.getDescription(),currGame.getReleaseDate().toString());
        System.out.println();
    }
}
