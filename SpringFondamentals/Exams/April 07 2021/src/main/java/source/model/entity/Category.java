package source.model.entity;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.Set;

@Entity
@Table(name = "categories")
public class Category extends BaseEntity {
    private String name;
    private int neededTime;

    @OneToMany(targetEntity = Order.class,mappedBy = "category")
    private Set<Order>orders;

    public Category(){}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNeededTime() {
        return neededTime;
    }

    public void setNeededTime(int neededTime) {
        this.neededTime = neededTime;
    }

    public Set<Order> getOrders() {
        return orders;
    }

    public void setOrders(Set<Order> orders) {
        this.orders = orders;
    }
}
