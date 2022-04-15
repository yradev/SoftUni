package car_dealer.entities.suppliers.importDataDTO;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "suppliers")
@XmlAccessorType(XmlAccessType.FIELD)
public class SuppliersImportDataDTO {
    @XmlElement(name = "supplier")
    private List<SupplierImportDataDTO> suppliers;

    public List<SupplierImportDataDTO> getSuppliers() {
        return suppliers;
    }

    public void setSuppliers(List<SupplierImportDataDTO> suppliers) {
        this.suppliers = suppliers;
    }
}
