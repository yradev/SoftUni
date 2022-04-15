package car_dealer.entities.suppliers.CollectionsDTO;

import car_dealer.entities.suppliers.SupplierWithoutImportedPartsFromAbroad;

import javax.xml.bind.annotation.*;
import java.util.List;

@XmlRootElement(name = "suppliers")
@XmlAccessorType(XmlAccessType.FIELD)
public class CollectionOfSuppliersWithoutImportedPartsFromAbroad {
    @XmlElement(name = "supplier")
    private List<SupplierWithoutImportedPartsFromAbroad> suppliers;

    public CollectionOfSuppliersWithoutImportedPartsFromAbroad() {
    }

    public CollectionOfSuppliersWithoutImportedPartsFromAbroad(List<SupplierWithoutImportedPartsFromAbroad> suppliers) {
        this.suppliers = suppliers;
    }


    public List<SupplierWithoutImportedPartsFromAbroad> getSuppliers() {
        return suppliers;
    }

    public void setSuppliers(List<SupplierWithoutImportedPartsFromAbroad> suppliers) {
        this.suppliers = suppliers;
    }
}
