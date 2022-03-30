package exam.model.shop;

import exam.model.laptop.Laptop;
import exam.model.town.Town;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Set;

@Entity
@Table(name = "shops")
public class Shop {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false,unique = true)
    private String name;

    @Column(nullable = false)
    private BigDecimal income;

    @Column(nullable = false)
    private String address;

    @Column(name = "employee_count",nullable = false)
    private int employeeCount;

    @Column(name = "shop_area",nullable = false)
    private int shopArea;

    @ManyToOne
    @JoinColumn(columnDefinition = "town_id",referencedColumnName = "id")
    private Town town;

    @OneToMany(targetEntity = Laptop.class,mappedBy = "shop")
    private Set<Laptop> laptops;

    public Shop(){}

    public Set<Laptop> getLaptops() {
        return laptops;
    }

    public void setLaptops(Set<Laptop> laptops) {
        this.laptops = laptops;
    }

    public Town getTown() {
        return town;
    }

    public void setTown(Town town) {
        this.town = town;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getEmployeeCount() {
        return employeeCount;
    }

    public void setEmployeeCount(int employeeCount) {
        this.employeeCount = employeeCount;
    }

    public int getShopArea() {
        return shopArea;
    }

    public void setShopArea(int shopArea) {
        this.shopArea = shopArea;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public BigDecimal getIncome() {
        return income;
    }

    public void setIncome(BigDecimal income) {
        this.income = income;
    }
}
