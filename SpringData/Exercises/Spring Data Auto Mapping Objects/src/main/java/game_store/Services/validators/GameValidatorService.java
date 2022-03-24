package game_store.Services.validators;

import java.math.BigDecimal;

public interface GameValidatorService {
    void validateTitle(String title);
    void validatePrice(BigDecimal price);
    void validateSize(BigDecimal size);
    void validateTrailer(String trailer);
    void validateThumbnailURL(String thumbnailURL);
    void validateDescription(String description);
    void validateGameById(int id);
    void validateGameByTitle(String title);
}
