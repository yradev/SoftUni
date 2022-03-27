package car_dealer.entities.customers.importDTO;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "customers")
@XmlAccessorType(XmlAccessType.FIELD)
public class CustomersImportDataDTO {
    @XmlElement(name = "customer")
    private List<CustomerImportDataDTO> customers;

    public List<CustomerImportDataDTO> getCustomers() {
        return customers;
    }

    public void setCustomers(List<CustomerImportDataDTO> customers) {
        this.customers = customers;
    }
}
