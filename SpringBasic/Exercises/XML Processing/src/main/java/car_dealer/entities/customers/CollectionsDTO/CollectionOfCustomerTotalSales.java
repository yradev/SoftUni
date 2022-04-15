package car_dealer.entities.customers.CollectionsDTO;

import car_dealer.entities.customers.CustomerTotalSales;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "customers")
@XmlAccessorType(XmlAccessType.FIELD)
public class CollectionOfCustomerTotalSales {
    @XmlElement(name = "customer")
    private List<CustomerTotalSales>customers;

    public CollectionOfCustomerTotalSales() {
    }

    public CollectionOfCustomerTotalSales(List<CustomerTotalSales> customers) {
        this.customers = customers;
    }

    public List<CustomerTotalSales> getCustomers() {
        return customers;
    }

    public void setCustomers(List<CustomerTotalSales> customers) {
        this.customers = customers;
    }
}
