package products_shop.Entities.Categories;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "categories")
@XmlAccessorType(XmlAccessType.FIELD)
public class CategoriesSeedDTO {
    @XmlElement
    private List<CategorySeedDTO> category;

    public List<CategorySeedDTO> getCategory() {
        return category;
    }

    public void setCategory(List<CategorySeedDTO> categorie) {
        this.category = categorie;
    }
}
