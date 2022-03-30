package exam.model.shop.ImportDTO;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "shops")
@XmlAccessorType(XmlAccessType.FIELD)
public class CollectionOfShopImportsDTO {
    @XmlElement(name = "shop")
    private List<ShopImportDTO>shops;

    public CollectionOfShopImportsDTO(){}

    public List<ShopImportDTO> getShops() {
        return shops;
    }

    public void setShops(List<ShopImportDTO> shops) {
        this.shops = shops;
    }
}
