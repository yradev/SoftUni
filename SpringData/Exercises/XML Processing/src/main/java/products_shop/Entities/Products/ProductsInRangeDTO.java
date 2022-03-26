package products_shop.Entities.Products;

import java.math.BigDecimal;

public class ProductsInRangeDTO {
    private String name;
    private BigDecimal price;
    private String seller;

    public ProductsInRangeDTO(String name, BigDecimal price, String firstName, String lastName) {
        this.name = name;
        this.price = price;
        if(firstName == null){
            seller = lastName;
        }else{
            seller = firstName + " " + lastName;
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
}
