package source.model.dto;

import org.springframework.format.annotation.DateTimeFormat;
import source.model.entity.Category;
import source.model.entity.User;

import javax.validation.constraints.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

public class AddOrderDTO {
    @Size(min = 3, max = 20, message = "Name must be between 3 and 20 characters.")
    private String name;
    @NotNull(message = "")
    @Positive(message = "Price must be positive.")
    private BigDecimal price;
    @NotNull(message = "")
    @PastOrPresent(message = "Order time cannot be in the future.")
    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm")
    private LocalDateTime orderTime;
    @Size(min = 5,message = "The description must be more than 5 characters.")
    private String description;
    private User user;
    private Category category;

    public AddOrderDTO(){}

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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public LocalDateTime getOrderTime() {
        return orderTime;
    }

    public void setOrderTime(LocalDateTime orderTime) {
        this.orderTime = orderTime;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
