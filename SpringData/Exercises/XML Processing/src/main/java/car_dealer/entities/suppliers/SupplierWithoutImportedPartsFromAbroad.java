package car_dealer.entities.suppliers;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;

@XmlAccessorType(XmlAccessType.FIELD)
public class SupplierWithoutImportedPartsFromAbroad {
    @XmlAttribute
    private int id;
    @XmlAttribute
    private String name;
    @XmlAttribute(name = "parts-count")
    private int partsCount;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPartsCount() {
        return partsCount;
    }

    public void setPartsCount(int partsCount) {
        this.partsCount = partsCount;
    }

    public SupplierWithoutImportedPartsFromAbroad(int id, String name, int partsCount) {
        this.id = id;
        this.name = name;
        this.partsCount = partsCount;
    }
}
