package car_dealer.entities.sales;

import car_dealer.entities.cars.CarInfoDTO;
import com.google.gson.annotations.Expose;

import java.math.BigDecimal;

public class SaleWithDiscount {
    @Expose
    private CarInfoDTO car;
    @Expose
    private String customerName;
    @Expose
    private Discounts Discount;
    @Expose
    private BigDecimal price;
    @Expose
    private BigDecimal priceWithDiscount;

    public SaleWithDiscount() {
    }

    public SaleWithDiscount(CarInfoDTO car, String customerName) {
        this.car = car;
        this.customerName = customerName;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public Discounts getDiscount() {
        return Discount;
    }

    public void setDiscount(Discounts discount) {
        Discount = discount;
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
