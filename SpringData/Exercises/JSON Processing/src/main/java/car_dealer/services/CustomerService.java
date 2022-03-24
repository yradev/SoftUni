package car_dealer.services;

import car_dealer.entities.customers.Customer;

import java.util.List;

public interface CustomerService {
    String getCustomersOrderedByBirthdateThanByIsYoungDriver();
    String getCustomersByTotalSpendMoney();
}
