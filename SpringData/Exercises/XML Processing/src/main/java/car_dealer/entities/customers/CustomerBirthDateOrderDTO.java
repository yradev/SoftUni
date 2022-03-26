package car_dealer.entities.customers;
import car_dealer.entities.sales.Sale;
import car_dealer.entities.sales.SaleInfoDTO;


import java.util.Set;

public class CustomerBirthDateOrderDTO {
    private String id;
    private String name;
    private String birthDate;
    private boolean isYoungDriver;

    private Set<SaleInfoDTO> sales;

    public Set<SaleInfoDTO> getSales() {
        return sales;
    }

    public void setSales(Set<SaleInfoDTO> sales) {
        this.sales = sales;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public boolean isYoungDriver() {
        return isYoungDriver;
    }

    public void setYoungDriver(boolean youngDriver) {
        isYoungDriver = youngDriver;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
