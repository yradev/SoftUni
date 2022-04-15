package products_shop.Entities.Categories;

import products_shop.Entities.Products.Product;

import javax.persistence.*;

import java.util.Set;

import static products_shop.Messages.Core.CATEGORIES_NAME_REQ;

@Entity(name = "categories")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column (nullable = false)
    private String name;

    @ManyToMany(mappedBy = "categories")
    private Set<Product>products;

    public Category() {
    }

    public Category(String name) {
        this.setName(name);
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        if(name.length()<3 || name.length()>15) {
            throw new IllegalArgumentException(CATEGORIES_NAME_REQ);
        }

        this.name = name;
    }

    public Set<Product> getProducts() {
        return products;
    }

    public void setProducts(Set<Product> products) {
        this.products = products;
    }
}
