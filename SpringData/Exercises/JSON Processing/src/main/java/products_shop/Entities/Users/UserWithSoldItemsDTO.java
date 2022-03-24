package products_shop.Entities.Users;

import products_shop.Entities.Products.SoldProductsDTO;

import java.util.Set;

public class UserWithSoldItemsDTO {
    private String firstName;
    private String lastName;
    private Set<SoldProductsDTO>boughtItems;

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
