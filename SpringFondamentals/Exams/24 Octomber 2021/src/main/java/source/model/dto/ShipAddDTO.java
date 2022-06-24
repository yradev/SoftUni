package source.model.dto;

import org.springframework.format.annotation.DateTimeFormat;
import source.model.entity.Categories;
import source.model.entity.Category;
import source.model.entity.User;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.*;
import java.time.LocalDate;

public class ShipAddDTO {
    @Size(min = 2, max = 10, message = "Name must be between 2 and 10 characters.")
    private String name;

    @Positive(message = "The power must be positive.")
    private int power;

    @Positive(message = "The health must be positive.")
    private int health;

    @PastOrPresent(message = "Created date cannot be in the future.")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate created;

    @NotNull(message = "Category cannot be null!")
    private Categories enumCategory;

    private Category category;

    private User user;

    public ShipAddDTO(){}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPower() {
        return power;
    }

    public void setPower(int power) {
        this.power = power;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public LocalDate getCreated() {
        return created;
    }

    public void setCreated(LocalDate created) {
        this.created = created;
    }

    public Categories getEnumCategory() {
        return enumCategory;
    }

    public void setEnumCategory(Categories enumCategory) {
        this.enumCategory = enumCategory;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
