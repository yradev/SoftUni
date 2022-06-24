package source.model.dto;

import source.model.entity.Category;
import source.model.entity.Order;

import java.util.Set;

public class EmployeeViewDTO {
    private String username;
    private Set<Order>orders;

    public EmployeeViewDTO(){}

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Set<Order> getOrders() {
        return orders;
    }

    public void setOrders(Set<Order> orders) {
        this.orders = orders;
    }
}
