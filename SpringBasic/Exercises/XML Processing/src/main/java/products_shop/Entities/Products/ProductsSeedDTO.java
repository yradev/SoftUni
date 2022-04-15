package products_shop.Entities.Products;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "products")
@XmlAccessorType(XmlAccessType.FIELD)
public class ProductsSeedDTO {
    @XmlElement
    private List<ProductSeedDTO> product;

    public List<ProductSeedDTO> getProducts() {
        return product;
    }

    public void setProducts(List<ProductSeedDTO> product) {
        this.product = product;
    }
}
