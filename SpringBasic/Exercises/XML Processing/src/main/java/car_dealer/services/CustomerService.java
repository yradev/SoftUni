package car_dealer.services;

import car_dealer.entities.customers.Customer;

import javax.xml.bind.JAXBException;
import java.util.List;

public interface CustomerService {
    void getCustomersOrderedByBirthdateThanByIsYoungDriver() throws JAXBException;
    void getCustomersByTotalSpendMoney() throws JAXBException;
}
