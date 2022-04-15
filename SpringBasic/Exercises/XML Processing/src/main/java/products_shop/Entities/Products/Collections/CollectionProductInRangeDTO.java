package products_shop.Entities.Products.Collections;

import products_shop.Entities.Products.ProductInRangeDTO;

import javax.xml.bind.annotation.*;
import java.util.List;

@XmlRootElement(name = "products")
@XmlAccessorType(XmlAccessType.FIELD)
public class CollectionProductInRangeDTO {
    @XmlElement(name = "product")
    private List<ProductInRangeDTO> products;

    public CollectionProductInRangeDTO(List<ProductInRangeDTO> products) {
        this.products = products;
    }

    public CollectionProductInRangeDTO() {
    }

    public List<ProductInRangeDTO> getProducts() {
        return products;
    }

    public void setProducts(List<ProductInRangeDTO> products) {
        this.products = products;
    }
}
