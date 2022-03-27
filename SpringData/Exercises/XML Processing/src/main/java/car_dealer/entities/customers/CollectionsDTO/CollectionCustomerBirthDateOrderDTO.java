package car_dealer.entities.customers.CollectionsDTO;

import car_dealer.entities.customers.CustomerBirthDateOrderDTO;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "customers")
@XmlAccessorType(XmlAccessType.FIELD)
public class CollectionCustomerBirthDateOrderDTO {
    @XmlElement(name = "customer")
    private List<CustomerBirthDateOrderDTO>customers;

    public CollectionCustomerBirthDateOrderDTO(){}

    public CollectionCustomerBirthDateOrderDTO(List<CustomerBirthDateOrderDTO> customers) {
        this.customers = customers;
    }


    public List<CustomerBirthDateOrderDTO> getCustomers() {
        return customers;
    }

    public void setCustomers(List<CustomerBirthDateOrderDTO> customers) {
        this.customers = customers;
    }
}
