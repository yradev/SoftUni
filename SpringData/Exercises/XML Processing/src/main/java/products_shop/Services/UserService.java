package products_shop.Services;

import javax.xml.bind.JAXBException;

public interface UserService {
    void getUserBySoldProjects() throws JAXBException;
    void getUsersByCountSoldProjects() throws JAXBException;
}
