package products_shop.Entities.Users.CollectionsDTO;

import products_shop.Entities.Users.UserWithSoldItemsDTO;

import javax.xml.bind.annotation.*;
import java.util.List;

@XmlAccessorType(XmlAccessType.FIELD)
public class CollectionUsersWithSoldItemsDTO {
    @XmlElement(name = "user")
    private List<UserWithSoldItemsDTO>users;

    public CollectionUsersWithSoldItemsDTO() {
    }

    public CollectionUsersWithSoldItemsDTO(List<UserWithSoldItemsDTO> users) {
        this.users = users;
    }

    public List<UserWithSoldItemsDTO> getUsers() {
        return users;
    }

    public void setUsers(List<UserWithSoldItemsDTO> users) {
        this.users = users;
    }
}
