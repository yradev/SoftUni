package car_dealer.entities.parts.importDTO;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "parts")
@XmlAccessorType(XmlAccessType.FIELD)
public class PartsImportDataDTO {
    @XmlElement(name = "part")
    private List<PartImportDataDTO> parts;

    public List<PartImportDataDTO> getParts() {
        return parts;
    }

    public void setParts(List<PartImportDataDTO> parts) {
        this.parts = parts;
    }
}
