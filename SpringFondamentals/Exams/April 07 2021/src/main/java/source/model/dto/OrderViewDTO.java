package source.model.dto;

import source.model.entity.User;

import java.math.BigDecimal;

public class OrderViewDTO {
    private long id;
    private String name;
    private BigDecimal price;
    private int categoryNeededTime;
    private String url;
    private User user;
    private String categoryName;

    public OrderViewDTO(){}

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


    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public int getCategoryNeededTime() {
        return categoryNeededTime;
    }

    public void setCategoryNeededTime(int categoryNeededTime) {
        this.categoryNeededTime = categoryNeededTime;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
