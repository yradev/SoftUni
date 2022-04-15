package car_dealer.entities.suppliers.importDataDTO;

import javax.xml.bind.annotation.*;

@XmlRootElement(name = "supplier")
@XmlAccessorType(XmlAccessType.FIELD)
public class SupplierImportDataDTO {
    @XmlAttribute
private String name;
    @XmlAttribute(name = "is-importer")
private boolean isImporter;

    public SupplierImportDataDTO() {
    }

    public SupplierImportDataDTO(String name, boolean isImporter) {
        this.name = name;
        this.isImporter = isImporter;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isImporter() {
        return isImporter;
    }

    public void setImporter(boolean importer) {
        isImporter = importer;
    }
}
