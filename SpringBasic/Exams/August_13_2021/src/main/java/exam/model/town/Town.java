package exam.model.town;

import exam.model.customer.Customer;
import exam.model.shop.Shop;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "towns")
public class Town {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false,unique = true)
    private String name;

    private int population;

    @Column(name = "travel_guide",nullable = false,columnDefinition = "TEXT")
    private String travelGuide;

    @OneToMany(targetEntity = Shop.class,mappedBy = "town")
    private Set<Shop> shops;

    @OneToMany(targetEntity = Customer.class,mappedBy = "town")
    private Set<Customer> customers;

    public Town(){}



    public Set<Shop> getShops() {
        return shops;
    }

    public void setShops(Set<Shop> shops) {
        this.shops = shops;
    }

    public Set<Customer> getCustomers() {
        return customers;
    }

    public void setCustomers(Set<Customer> customers) {
        this.customers = customers;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPopulation() {
        return population;
    }

    public void setPopulation(int population) {
        this.population = population;
    }

    public String getTravelGuide() {
        return travelGuide;
    }

    public void setTravelGuide(String travelGuide) {
        this.travelGuide = travelGuide;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
