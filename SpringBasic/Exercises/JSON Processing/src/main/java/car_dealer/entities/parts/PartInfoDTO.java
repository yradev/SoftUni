package car_dealer.entities.parts;

import java.math.BigDecimal;

public class PartInfoDTO {
    private String Name;
    private BigDecimal Price;

    public PartInfoDTO(String name, BigDecimal price) {
        Name = name;
        Price = price;
    }

    public PartInfoDTO() {
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public BigDecimal getPrice() {
        return Price;
    }

    public void setPrice(BigDecimal price) {
        Price = price;
    }
}
