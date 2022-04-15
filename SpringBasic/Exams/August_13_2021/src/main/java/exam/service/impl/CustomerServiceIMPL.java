package exam.service.impl;

import com.google.gson.Gson;
import exam.model.customer.Customer;
import exam.model.customer.ImportDTO.CustomerImportDTO;
import exam.model.town.Town;
import exam.repository.CustomerRepository;
import exam.repository.TownRepository;
import exam.service.CustomerService;
import exam.service.ValidatingService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.util.Arrays;
import java.util.stream.Collectors;

import static exam.util.Paths.JSON_CUSTOMERS_DATA;

@Service
public class CustomerServiceIMPL implements CustomerService {
    private final CustomerRepository customerRepository;
    private final TownRepository townRepository;
    private final ValidatingService validatingService;
    private final Gson gson;
    private final ModelMapper modelMapper;

    public CustomerServiceIMPL(CustomerRepository customerRepository, TownRepository townRepository, ValidatingService validatingService, Gson gson, ModelMapper modelMapper) {
        this.customerRepository = customerRepository;
        this.townRepository = townRepository;
        this.validatingService = validatingService;
        this.gson = gson;
        this.modelMapper = modelMapper;
    }

    @Override
    public boolean areImported() {
        return customerRepository.count()>0;
    }

    @Override
    public String readCustomersFileContent() throws IOException {
        return Files.readString(JSON_CUSTOMERS_DATA);
    }

    @Override
    public String importCustomers() throws IOException {
        return Arrays.stream(gson.fromJson(Files.readString(JSON_CUSTOMERS_DATA),CustomerImportDTO[].class))
                .map(this::importValidDataToDataBase)
                .collect(Collectors.joining(System.lineSeparator()));

    }

    private String importValidDataToDataBase(CustomerImportDTO customerImportDTO) {
        if(!validatingService.ValidateCustomer(customerImportDTO)){
            return "Invalid Customer";
        }

        if(customerRepository.findCustomerByEmail(customerImportDTO.getEmail())!=null){
            return "Invalid Customer";
        }

        Customer customer = modelMapper.map(customerImportDTO,Customer.class);

        Town town = townRepository.findTownByName(customerImportDTO.getTown().getName());
        customer.setTown(town);

        customerRepository.save(customer);
        return String.format("Successfully imported Customer %s %s - %s",customer.getFirstName(), customer.getLastName(), customer.getEmail());
    }
}
