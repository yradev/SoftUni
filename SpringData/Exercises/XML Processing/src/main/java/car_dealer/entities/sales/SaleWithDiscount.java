package car_dealer.entities.sales;

import car_dealer.entities.cars.CarInfoDTO;

import javax.xml.bind.annotation.*;
import java.math.BigDecimal;

@XmlAccessorType(XmlAccessType.FIELD)
public class SaleWithDiscount {

    @XmlElement
    private CarInfoDTO car;
    @XmlElement(name = "customer-name")
    private String customerName;
    @XmlElement
    private Discounts discount;
    @XmlElement
    private BigDecimal price;
    @XmlElement(name = "price-with-discount")
    private BigDecimal priceWithDiscount;

    public SaleWithDiscount() {
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public Discounts getDiscount() {
        return discount;
    }

    public void setDiscount(Discounts discount) {
        this.discount = discount;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public BigDecimal getPriceWithDiscount() {
        return priceWithDiscount;
    }

    public void setPriceWithDiscount(BigDecimal priceWithDiscount) {
        this.priceWithDiscount = priceWithDiscount;
    }

    public CarInfoDTO getCar() {
        return car;
    }

    public void setCar(CarInfoDTO car) {
        this.car = car;
    }
}
