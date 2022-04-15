package car_dealer.entities.customers;

import java.math.BigDecimal;

public class CustomerTotalSales {
    private String fullName;
    private int boughtCars;
    private BigDecimal spendMoney;

    public CustomerTotalSales(String fullName, int boughtCars, BigDecimal spendMoney) {
        this.fullName = fullName;
        this.boughtCars = boughtCars;
        this.spendMoney = spendMoney;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public int getBoughtCars() {
        return boughtCars;
    }

    public void setBoughtCars(int boughtCars) {
        this.boughtCars = boughtCars;
    }

    public BigDecimal getSpendMoney() {
        return spendMoney;
    }

    public void setSpendMoney(BigDecimal spendMoney) {
        this.spendMoney = spendMoney;
    }
}
