package car_dealer.services.IMPL;

import car_dealer.entities.customers.CollectionsDTO.CollectionCustomerBirthDateOrderDTO;
import car_dealer.entities.customers.CollectionsDTO.CollectionOfCustomerTotalSales;
import car_dealer.entities.customers.CustomerBirthDateOrderDTO;
import car_dealer.entities.customers.CustomerTotalSales;
import car_dealer.repositories.CustomerRepository;
import car_dealer.services.CustomerService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CustomerServiceIMPL implements CustomerService {
    private final CustomerRepository customerRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public CustomerServiceIMPL(CustomerRepository customerRepository, ModelMapper modelMapper) {
        this.customerRepository = customerRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public void getCustomersOrderedByBirthdateThanByIsYoungDriver() throws JAXBException {

       List<CustomerBirthDateOrderDTO> customer =  customerRepository.findAllCustomersOrderByBirthDateThanByIsYoungDriver().stream()
               .map(a->modelMapper.map(a,CustomerBirthDateOrderDTO.class))
               .collect(Collectors.toList());

        CollectionCustomerBirthDateOrderDTO input = new CollectionCustomerBirthDateOrderDTO(customer);

        Marshaller marshaller = JAXBContext.newInstance(CollectionCustomerBirthDateOrderDTO.class).createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT,true);
        marshaller.marshal(input,System.out);
    }

    @Override
    public void getCustomersByTotalSpendMoney() throws JAXBException {
        List<CustomerTotalSales> customers = customerRepository.findAllCustomersWithTotalSales();
        CollectionOfCustomerTotalSales input = new CollectionOfCustomerTotalSales(customers);
        Marshaller marshaller = JAXBContext.newInstance(CollectionOfCustomerTotalSales.class).createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT,true);
        marshaller.marshal(input,System.out);
    }
}
