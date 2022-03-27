package car_dealer.entities.sales.CollectionsDTO;

import car_dealer.entities.sales.SaleWithDiscount;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "sales")
@XmlAccessorType(XmlAccessType.FIELD)
public class CollectionOfSaleWithDiscount {
    @XmlElement(name = "sale")
   private List<SaleWithDiscount> sales;

    public CollectionOfSaleWithDiscount(){}

    public CollectionOfSaleWithDiscount(List<SaleWithDiscount> sales) {
        this.sales = sales;
    }

    public List<SaleWithDiscount> getSales() {
        return sales;
    }

    public void setSales(List<SaleWithDiscount> sales) {
        this.sales = sales;
    }
}
