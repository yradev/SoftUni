package products_shop.Entities.Users;

import products_shop.Entities.Products.Product;

import javax.persistence.*;

import java.util.*;

import static products_shop.Messages.Core.*;

@Entity
@Table(name = "users")
public class  User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "first_name")
    private String firstName;


    @Column(name = "last_name",nullable = false)
    private String lastName;

    int age;

    @OneToMany(targetEntity = Product.class,mappedBy = "seller")
    private Set<Product> sellingItems;

    @OneToMany(targetEntity = Product.class,mappedBy = "buyer")
    private Set<Product> boughtItems;

    public Set<Product> getSellingItems() {
        return sellingItems;
    }

    public void setSellingItems(Set<Product> sellingItems) {
        this.sellingItems = sellingItems;
    }

    public Set<Product> getBoughtItems() {
        return boughtItems;
    }

    public void setBoughtItems(Set<Product> boughtItems) {
        this.boughtItems = boughtItems;
    }

    @ManyToMany
    @JoinTable(
            joinColumns = @JoinColumn(name = "user_id",referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "friend_id",referencedColumnName = "id"))
    private Set<User>friends;

    public User(String firstName, String lastName, int age) {
        this.firstName = firstName;
        this.setLastName(lastName);
        this.age = age;
    }

    public User() {
        this.sellingItems = new LinkedHashSet<>();
        this.boughtItems = new LinkedHashSet<>();
        this.friends = new HashSet<>();
    }

    public Set<User> getFriends() {
        return friends;
    }

    public void setFriends(Set<User> friends) {
        this.friends = friends;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        if(lastName.length()<3) {
            throw new IllegalArgumentException(USERS_LAST_NAME_REQ);
        }

        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
