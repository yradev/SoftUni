package source.model.entity;

import ch.qos.logback.classic.db.names.ColumnName;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "orders")
public class Order extends BaseEntity {
    private String name;
    private BigDecimal price;
    @Column(name = "order_time")
    private LocalDateTime orderTime;

    @ManyToOne
    private Category category;

    @Column(columnDefinition = "text")
    private String description;

    @ManyToOne
    @JoinColumn(name="employee_id")
    private User user;

    public Order(){}

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

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
