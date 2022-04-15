package products_shop.Entities.Categories.Collections;

import products_shop.Entities.Categories.CategorieByProductsCountDTO;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "categories")
@XmlAccessorType(XmlAccessType.FIELD)
public class CollectionOfCategorieByProductCountDTO {
    @XmlElement(name = "category")
private List<CategorieByProductsCountDTO> categories;

    public CollectionOfCategorieByProductCountDTO(List<CategorieByProductsCountDTO> categories) {
        this.categories = categories;
    }

    public CollectionOfCategorieByProductCountDTO(){}


    public List<CategorieByProductsCountDTO> getCategories() {
        return categories;
    }

    public void setCategories(List<CategorieByProductsCountDTO> categories) {
        this.categories = categories;
    }
}
