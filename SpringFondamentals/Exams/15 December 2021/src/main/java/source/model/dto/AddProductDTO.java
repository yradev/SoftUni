package source.model.dto;

import org.springframework.format.annotation.DateTimeFormat;
import source.model.entity.Categories;

import javax.validation.constraints.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

public class AddProductDTO {
    @Size(min = 3, max = 20, message = "Name length must be between 3 and 20 characters characters!")
    private String name;
    @Size(min = 5, message = "Description length must be more than 5 characters!")
    private String description;

    @FutureOrPresent(message = "The date cannot be in the past!")
    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm")
    private LocalDateTime before;
    @Positive(message = "Price must be positive number!")
    private BigDecimal price;
    @NotNull(message = "Category cannot be null!")
    private Categories category;

    public AddProductDTO(){}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


    public LocalDateTime getBefore() {
        return before;
    }

    public void setBefore(LocalDateTime before){
        this.before = before;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Categories getCategory() {
        return category;
    }

    public void setCategory(Categories category) {
        this.category = category;
    }
}
