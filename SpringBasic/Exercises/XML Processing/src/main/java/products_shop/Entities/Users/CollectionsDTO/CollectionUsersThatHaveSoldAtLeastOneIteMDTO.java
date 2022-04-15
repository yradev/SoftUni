package products_shop.Entities.Users.CollectionsDTO;

import products_shop.Entities.Products.SoldProductsDTO;
import products_shop.Entities.Users.UserWithSoldItemsDTO;

import javax.xml.bind.annotation.*;
import java.util.List;
@XmlRootElement(name = "users")
@XmlAccessorType(XmlAccessType.FIELD)
public class CollectionUsersThatHaveSoldAtLeastOneIteMDTO {
    @XmlElement(name = "user")
    private List<UserWithSoldItemsDTO> users;

    @XmlAttribute
    private int count;

    public CollectionUsersThatHaveSoldAtLeastOneIteMDTO() {
    }

    public List<UserWithSoldItemsDTO> getUsers() {
        return users;
    }

    public void setUsers(List<UserWithSoldItemsDTO> users) {
        this.users = users;
        count = users.size();
    }
}
