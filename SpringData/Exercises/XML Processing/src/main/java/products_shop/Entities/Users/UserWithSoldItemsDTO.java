package products_shop.Entities.Users;

import products_shop.Entities.Products.SoldProductsDTO;

import javax.xml.bind.annotation.*;
import java.util.Set;

@XmlAccessorType(XmlAccessType.FIELD)
public class UserWithSoldItemsDTO {
    @XmlAttribute(name = "first-name")
    private String firstName;
    @XmlAttribute(name = "last_name")
    private String lastName;

    @XmlAttribute
    private int age;

    @XmlElementWrapper(name = "sold-products")
    @XmlElement(name = "product")
    private Set<SoldProductsDTO>boughtItems;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
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
        this.lastName = lastName;
    }

    public Set<SoldProductsDTO> getBoughtItems() {
        return boughtItems;
    }

    public void setBoughtItems(Set<SoldProductsDTO> boughtItems) {
        this.boughtItems = boughtItems;
    }
}
