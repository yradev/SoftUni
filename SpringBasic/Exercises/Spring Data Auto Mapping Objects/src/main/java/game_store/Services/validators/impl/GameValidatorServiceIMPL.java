package game_store.Services.validators.impl;

import game_store.Repositories.GameRepository;
import game_store.Services.validators.GameValidatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

import static game_store.Messages.CoreMessages.*;

@Service
public class GameValidatorServiceIMPL implements GameValidatorService {
    private GameRepository gameRepository;

    @Autowired
    public GameValidatorServiceIMPL(GameRepository gameRepository) {
        this.gameRepository = gameRepository;
    }

    @Override
    public void validateTitle(String title) {

        if(title.length()<3 || title.length()>100){
            throw new IllegalArgumentException(INCORRECT_TITLE_LENGTH);
        }

        if(!title.matches("^[A-Z][\\D]+")){
            throw new IllegalArgumentException(INCORRECT_TITLE_UPPER);
        }
    }

    @Override
    public void validatePrice(BigDecimal price) {
        if(price.intValue()<0){
            throw new IllegalArgumentException(INCORRECT_PRICE);
        }
    }

    @Override
    public void validateSize(BigDecimal size) {
        if(size.intValue()<0){
            throw new IllegalArgumentException(INCORRECT_SIZE);
        }
    }

    @Override
    public void validateTrailer(String trailer) {
        if(trailer.length()<11){
            throw new IllegalArgumentException(INCORRECT_TRAILER);
        }
    }

    @Override
    public void validateThumbnailURL(String thumbnailURL) {
        if(!thumbnailURL.matches("^http:\\/\\/+[\\D]+|^https:\\/\\/+[\\D]+|")){
            throw new IllegalArgumentException(INCORRECT_THUMBNAIL_URL);
        }
    }

    @Override
    public void validateDescription(String description) {
        if(description.length()<20){
            throw new IllegalArgumentException(INCORRECT_DESCRIPTION);
        }
    }

    @Override
    public void validateGameById(int id) {
        if(gameRepository.findGameById(id).size()==0){
            throw new IllegalArgumentException(USER_DIDNT_EXIST);
        }
    }

    @Override
    public void validateGameByTitle(String title) {
        if(gameRepository.findGamesByTitle(title).size() == 0){
            throw new IllegalArgumentException(USER_DIDNT_EXIST);
        }
    }
}
