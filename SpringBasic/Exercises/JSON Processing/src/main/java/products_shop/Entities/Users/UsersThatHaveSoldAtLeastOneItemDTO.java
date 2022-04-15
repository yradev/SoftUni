package products_shop.Entities.Users;

import products_shop.Entities.Products.SoldProductsDTO;

import java.util.List;

public class UsersThatHaveSoldAtLeastOneItemDTO {
    private int usersCount;
    private List<UserWithSoldItemsDTO> users;

    public UsersThatHaveSoldAtLeastOneItemDTO(int usersCount) {
        this.usersCount = usersCount;
    }

    public int getUsersCount() {
        return usersCount;
    }

    public List<UserWithSoldItemsDTO> getUsers() {
        return users;
    }


    public void setUsers(List<UserWithSoldItemsDTO> users) {
        this.users = users;
    }
}
