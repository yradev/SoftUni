package car_dealer.services.IMPL;

import car_dealer.entities.customers.Customer;
import car_dealer.entities.customers.CustomerBirthDateOrderDTO;
import car_dealer.repositories.CustomerRepository;
import car_dealer.services.CustomerService;
import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CustomerServiceIMPL implements CustomerService {
    private final CustomerRepository customerRepository;
    private final Gson gson;
    private final ModelMapper modelMapper;

    @Autowired
    public CustomerServiceIMPL(CustomerRepository customerRepository, Gson gson, ModelMapper modelMapper) {
        this.customerRepository = customerRepository;
        this.gson = gson;
        this.modelMapper = modelMapper;
    }

    @Override
    public String getCustomersOrderedByBirthdateThanByIsYoungDriver() {

       List<CustomerBirthDateOrderDTO> customer =  customerRepository.findAllCustomersOrderByBirthDateThanByIsYoungDriver().stream()
               .map(a->modelMapper.map(a,CustomerBirthDateOrderDTO.class))
               .collect(Collectors.toList());

       return gson.toJson(customer);
    }

    @Override
    public String getCustomersByTotalSpendMoney() {
        return gson.toJson(customerRepository.findAllCustomersWithTotalSales());
    }
}
