package source.model.entity;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "ships")
public class Ship extends BaseEntity{
    @Column(unique = true)
    private String name;
    private int health;
    private int power;
    private LocalDate created;

    @OneToOne
    private User user;

    @ManyToOne
    private Category category;

    private Category getCategory() {
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

    public Ship(){}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getPower() {
        return power;
    }

    public void setPower(int power) {
        this.power = power;
    }

    public LocalDate getCreated() {
        return created;
    }

    public void setCreated(LocalDate created) {
        this.created = created;
    }
}
